import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class CalculateBill extends JFrame implements ActionListener {

    JTextField tfname,tfaddress,tfstate,tfunits,tfemail,tfphone;
    JButton next,cancel;
    JLabel lblname,labeladdress;
    Choice meternumber,cmonth;
    CalculateBill(){
        setSize(700,500);
        setLocation(400,150);

        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100,10,400,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100,80,100,20);
        p.add(lblmeternumber);

        meternumber = new Choice();

        try{
            Connection connection =Conn.establishConnection();
            String query = "Select * from customer";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        meternumber.setBounds(240,80,200,20);
        p.add(meternumber);

        JLabel lblmeterno=new JLabel("Name");
        lblmeterno.setBounds(100,120,100,20);
        p.add(lblmeterno);

        lblname = new JLabel("");
        lblname.setBounds(240,120,100,20);
        p.add(lblname);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);

        labeladdress=new JLabel();
        labeladdress.setBounds(240,160,200,20);
        p.add(labeladdress);
        try{
            Connection connection =Conn.establishConnection();
            String query = "select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        meternumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Connection connection =Conn.establishConnection();
                    String query = "select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'";
                    Statement st=connection.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while (rs.next()){
                        lblname.setText(rs.getString("name"));
                        labeladdress.setText(rs.getString("address"));
                    }
                }catch (Exception es){
                    es.printStackTrace();
                }

            }
        });

        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);

        tfunits=new JTextField();
        tfunits.setBounds(240,200,200,20);
        p.add(tfunits);

        JLabel lblState = new JLabel("Month");
        lblState.setBounds(100,240,100,20);
        p.add(lblState);

        cmonth=new Choice();
        cmonth.setBounds(240,240,200,20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);

        next=new JButton("Submit");
        next.setBounds(120,350,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel=new JButton("Cancel");
        cancel.setBounds(250,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image I2=I1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month=cmonth.getSelectedItem();

            int totalbill = 0;
            int unit_consumed=Integer.parseInt(units);

            String query="Select * from tax";

            try{
                Conn c=new Conn();
                Connection connection =Conn.establishConnection();
                Statement s=connection.createStatement();
                ResultSet rs=s.executeQuery(query);
                while (rs.next()){
                    totalbill+= unit_consumed *Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                    totalbill+=Integer.parseInt(rs.getString("service_charge"));
                    totalbill+=Integer.parseInt(rs.getString("service_tax"));
                    totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
            try{
                Conn c=new Conn();
                Connection connection =Conn.establishConnection();
                Statement s=connection.createStatement();
                s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Customer Bill updated Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new CalculateBill();
    }
}

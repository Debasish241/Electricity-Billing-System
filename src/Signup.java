import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    Choice accountType;
    JTextField meter,username,name,password;
    Signup(){
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         JPanel panel=new JPanel();
         panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(110,50,140,20);
        heading.setForeground(Color.GRAY);
        setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(heading);

        accountType=new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260,90,150,20);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.GRAY);
        setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);

        JLabel lblpassword = new JLabel("Passwod");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,260,120,25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image I2=I1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        image.setBounds(415,30,250,250);
        panel.add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String atype=accountType.getSelectedItem();
            String susername =username.getText();
            String sname=name.getText();
            String spassword=password.getText();
            String smeter = meter.getText();



            try{
                Conn c=new Conn();
                Connection connection =Conn.establishConnection();
                String query="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
                Statement s=connection.createStatement();
                s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();

            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

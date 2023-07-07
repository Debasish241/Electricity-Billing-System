import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
    JButton login,Cancel,Signup;
    JTextField username,password;
    Choice loginin;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//      Conn.establishConnection();

        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(300,20,100,20);
        add(lblusername);

        username = new JTextField();
        username.setBounds(400,20,150,20);
        add(username);

        JLabel lbpassword=new JLabel("Passwod");
        lbpassword.setBounds(300,60,100,20);
        add(lbpassword);

        password=new JTextField();
        password.setBounds(400,60,150,20);
        add(password);

        JLabel logininas=new JLabel("Login in as");
        logininas.setBounds(300,100,100,20);
        add(logininas);

        loginin=new Choice();
        loginin.add("Admin");
        loginin.add("Customer");
        loginin.setBounds(400,100,150,20);
        add(loginin);

        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image I2 = I1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        login =new JButton("Login",new ImageIcon(I2));
        login.setBounds(330,160,100,20);
        login.addActionListener(this);

        add(login);

        ImageIcon I3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image I4 = I3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Cancel =new JButton("Cancel",new ImageIcon(I4));
        Cancel.setBounds(450,160,100,20);
        Cancel.addActionListener(this);
        add(Cancel);



        ImageIcon I5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image I6 = I5.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Signup =new JButton("Signup",new ImageIcon(I6));
        Signup.setBounds(380,200,100,20);
        Signup.addActionListener(this);
        add(Signup);

        ImageIcon I7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image I8 = I7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);

        ImageIcon I9=new ImageIcon(I8);
        JLabel image=new JLabel(I9);
        image.setBounds(0,0,250,250);
        add(image);

        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }

public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==login){
            String susername=username.getText();
            String spassword=password.getText();
            String user = loginin.getSelectedItem();

            try{
//                Conn c=new Conn();
                Connection connection =Conn.establishConnection();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and userN = '"+user+"'";
                Statement st=connection.createStatement();
                ResultSet rs=st.executeQuery(query);
//                Statement s=connection.createStatement();
//                s.executeUpdate(query);
//                System.out.println("rs.next="+rs.next());
                if(rs.next()){
                    String meter = rs.getString("meter_no");
//                    System.out.println(rs.getString("susername"));
//                    System.out.println(rs.getString("spassword"));
                        if(spassword.equals(rs.getString("password"))) {
                            setVisible(false);
                            new Project(user,meter);
                        }
                    connection.close();
//                    setVisible(false);
//                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    username.setText("");
                    password.setText("");
                }


            }catch (Exception e)
            {
                e.printStackTrace();
            }
        } else if (ae.getSource()==Cancel) {
            setVisible(false);
        } else if (ae.getSource()==Signup) {
            setVisible(false);
            new Signup();
        }
}
    public static void main(String[] args) {
        new Login();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Project extends JFrame {
    Project(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image I2=I1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        add(image);

        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);

        JMenu master =new JMenu("Master");
        master.setForeground(Color.BLUE);
        mb.add(master);

        JMenuItem newcustomer = new JMenuItem("new Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon Icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=Icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);


        JMenuItem customerdetails = new JMenuItem("new Customer");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon Icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=Icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerdetails);


        JMenuItem depositdetails = new JMenuItem("new Customer");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon Icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=Icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('N');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositdetails);


        JMenuItem calculatebill = new JMenuItem("new Customer");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon Icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4=Icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);



        JMenu info =new JMenu("Information");
        info.setForeground(Color.RED);
        mb.add(info);

        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinformation.setBackground(Color.WHITE);
        ImageIcon Icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5=Icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        updateinformation.setMnemonic('P');
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateinformation);

        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinformation.setBackground(Color.WHITE);
        ImageIcon Icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=Icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        viewinformation.setMnemonic('B');
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        info.add(viewinformation);

        JMenu user =new JMenu("User");
        user.setForeground(Color.BLUE);
        mb.add(user);

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        ImageIcon Icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7=Icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('R');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon Icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8=Icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('B');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdetails);

        JMenu report =new JMenu("Report");
        report.setForeground(Color.RED);
        mb.add(report);

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon Icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9=Icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);


        JMenu utility =new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon Icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=Icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);


        JMenu mexit =new JMenu("Exit");
        mexit.setForeground(Color.RED);
        mb.add(mexit);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon Icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=Icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);


        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        ImageIcon Icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=Icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('N');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(calculator);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {
    Choice meternumber,cmonth ;
    JTable table;
    JButton search,print;

    CustomerDetails(){
        super("Customer Details");

        setSize(1200,650);
        setLocation(200,150);

        table=new JTable();
        try {
            Connection connection =Conn.establishConnection();
            String query = "Select * from customer";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp=new JScrollPane(table);
        add(sp);

        print =new JButton("Print");
        print.addActionListener(this);
        add(print,"South");

        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){

            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        new CustomerDetails();

    }
}

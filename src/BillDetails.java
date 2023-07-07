import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{

    BillDetails(String meter) {

        setSize(700, 650);
        setLocation(400, 150);

        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();

        try {
            Connection connection =Conn.establishConnection();
            String query = ("select * from bill where meter_no = '"+meter+"'");
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    static Connection con;
    public static Connection establishConnection() {


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "debasish");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
    }

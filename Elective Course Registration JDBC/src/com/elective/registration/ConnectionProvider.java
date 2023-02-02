// import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    static Connection con;

    public static Connection createConnection(){
        try {
            // loading the driver
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection
            String USER = "root";
            String PASSWORD = "12345";
            String URL = "jdbc:mysql://localhost:3306/elective_registration_jdbc";

            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

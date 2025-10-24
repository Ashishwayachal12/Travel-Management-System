import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            String url = "jdbc:mysql://mysql:3306/travel"; // 'mysql' = service name in docker-compose
            String user = "root";
            String password = "Ashish@99";
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

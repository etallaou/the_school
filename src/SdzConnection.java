import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SdzConnection {
    private String url = "jdbc:postgresql://localhost:5432/school";
    private String user = "postgres";
    private String pass = "postgres";
    private static Connection connection;

    private SdzConnection(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if(connection == null){
            new SdzConnection();
            System.out.println("IF SQL START");
        } else {
            System.out.println("ELSE SQL START");
        }
        return connection;
    }

}

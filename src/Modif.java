import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modif {
    public static void main(String[] args) {
        try{

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT prof_id, prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";

            ResultSet res = statement.executeQuery(query);
            res.first();

            System.out.println("Name: " +res.getString("prof_nom") + " - " + res.getString("prof_prenom"));

            res.updateString("prof_nom", "TALLA");
            res.updateString("prof_prenom", "OUAFEU");

            res.updateRow();

            System.out.println("Name: " +res.getString("prof_nom") + " - " + res.getString("prof_prenom"));

            res.updateString("prof_nom", "MAMOU");
            res.updateString("prof_prenom", "DANIEL");

            res.updateRow();

            System.out.println("Name: " +res.getString("prof_nom") + " - " + res.getString("prof_prenom"));

            res.close();
            statement.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT prof_nom, prof_prenom FROM professeur";
            ResultSet res = statement.executeQuery(query);
            int i = 1;

            System.out.println("\n\t ----------------------------------------");
            System.out.println("\t standard listening");
            System.out.println("\n\t ----------------------------------------");


            while (res.next()){
                System.out.println("\tname: "+ res.getString("prof_nom") +
                        " \t first name: " + res.getString("prof_prenom"));

                if(res.isLast())
                    System.out.println("\t\t* LAST RESULT! \n");
                i++;
            }

            if (res.isAfterLast())
                System.out.println("\t  END of the game");



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

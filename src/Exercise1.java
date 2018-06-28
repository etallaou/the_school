import java.sql.*;

public class Exercise1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url =  "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM professeur");

            ResultSetMetaData resultMeta = result.getMetaData();
            Integer columnCount = resultMeta.getColumnCount();

            System.out.println("- This table has " + columnCount + "\n");
            for (int i = 1; i <= columnCount; i++)
                System.out.println("\t * " + resultMeta.getColumnName(i));

            System.out.println("-----------------------------------------------");

            while (result.next()){
                String fName = result.getString("prof_prenom");
                String lName = result.getString("prof_nom");

                System.out.println("\t" + fName + " | " + lName );
            }

            result.close();
            state.close();




        } catch (Exception e) {

        }
    }
}

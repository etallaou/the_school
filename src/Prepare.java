import java.sql.*;

public class Prepare {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection conn = DriverManager.getConnection(url, user, pass);

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


            String query = "SELECT prof_nom, prof_prenom FROM professeur";
            query += " WHERE prof_nom = ?";
            query += " OR prof_id = ?";

            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setString(1, "MANU");
            prepare.setInt(2, 2);

            System.out.println(prepare.toString());

            prepare.setString(1, "TOTO");


            System.out.println(prepare.toString());
            prepare.setInt(1, 1577777);

            System.out.println(prepare.toString());

            prepare.clearParameters();

            System.out.println(prepare.toString());

            prepare.close();
            state.close();



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class Exercise2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K");

            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement state = conn.createStatement();

            String query = "SELECT prof_nom, prof_prenom, mat_nom from professeur";
            query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
            query += " INNER JOIN matiere ON jmp_mat_k = mat_id ORDER BY prof_nom";

            ResultSet result = state.executeQuery(query);
            String name = "";

            while (result.next()){
                String profName =result.getString("prof_nom");
                String profFName = result.getString("prof_prenom");
                if(!name.equals(profName)){
                    name = profName;
                    System.out.println(name + " " + profFName + " teach :" );
                }
                System.out.println("\t\t\t - " + result.getString("mat_nom"));
            }

            result.close();
            state.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise3 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K");

            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement state = conn.createStatement();

            String query = "SELECT prof_nom, prof_prenom, mat_nom, cls_nom from professeur";
            query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
            query += " INNER JOIN matiere ON jmp_mat_k = mat_id";
            query += " INNER JOIN j_cls_jmp ON jcm_jmp_k = jmp_id";
            query += " INNER JOIN classe ON jcm_cls_k = cls_id AND cls_id IN(1, 7)";
            query += "ORDER by cls_nom DESC, prof_nom";

            ResultSet result = state.executeQuery(query);
            String name = "";
            String classroomName = "";

            while (result.next()){
                String profName =result.getString("prof_nom");
                String profFName = result.getString("prof_prenom");
                String resultClassroomName = result.getString("cls_nom");

                if(!classroomName.equals(resultClassroomName)){
                    System.out.println("--------------------------------------------------");
                    classroomName = resultClassroomName;
                    System.out.println("the classroom: " + classroomName + " :");
                    System.out.println(name + " " + profFName + " teach :" );
                }

                if(!name.equals(profName)){
                    name = profName;
                    System.out.println("\t *" + name + " " + profFName + " teach :" );
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

import java.sql.*;

public class TestState {
    public static void main(String[] args) {
        try {


            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String pass = "postgres";

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE professeur set prof_nom = ? " +
            "WHERE prof_nom = ?");

            String q = "SELECT prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";

            ResultSet resultSet = statement.executeQuery(q);

            resultSet.first();


            System.out.println("Name: " + resultSet.getString("prof_nom") + " - First name: " +
                    resultSet.getString("prof_prenom"));

            preparedStatement.setString(1, "TALLA");
            preparedStatement.setString(2, "MAMOU");
            preparedStatement.executeUpdate();

            q = "SELECT prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'TALLA'";

            resultSet = statement.executeQuery(q);
            resultSet.first();

            System.out.println("Name: " + resultSet.getString("prof_nom") + " - First name: " +
                    resultSet.getString("prof_prenom"));

            System.out.println(preparedStatement.toString());

            preparedStatement.setString(1, "MAMOU");
            preparedStatement.setString(2, "TALLA");

            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

            q = "SELECT prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";
            resultSet = statement.executeQuery(q);
            resultSet.first();

            System.out.println("Name: " + resultSet.getString("prof_nom") + " - First name: " +
                    resultSet.getString("prof_prenom"));



            preparedStatement.close();
            resultSet.close();
            statement.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

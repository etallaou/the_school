import java.sql.*;

public class Connect {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String passwd = "postgres";

            Connection connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connected");

            Statement state = connection.createStatement();

            ResultSet result = state.executeQuery("SELECT * FROM classe");

            ResultSetMetaData resultSetMetaData = result.getMetaData();

            System.out.println("\n ********************************");

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                System.out.print("\t" + resultSetMetaData.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n ***************************************************");

            while (result.next()){
                for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                    System.out.print("\t"+ result.getObject(i).toString() + "\t |");
                System.out.println("\n--------------------------------");

            }

            result.close();
            state.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

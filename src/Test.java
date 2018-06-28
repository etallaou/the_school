import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        try {


            PreparedStatement preparedStatement = SdzConnection.getInstance()
                    .prepareStatement("SELECT * FROM classe WHERE cls_nom = ?");

            Statement statement = SdzConnection.getInstance().createStatement();

            SdzConnection.getInstance().setAutoCommit(false);

            DatabaseMetaData metaData = SdzConnection.getInstance().getMetaData();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

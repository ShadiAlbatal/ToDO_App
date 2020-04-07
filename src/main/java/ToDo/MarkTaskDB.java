package ToDo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MarkTaskDB {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public MarkTaskDB() throws SQLException {
    }

    public void Mark(){
        dBinfo.useDB();
        //String sortproject= "select * from " + dBinfo.getTableName() + " order by Project";

        System.out.println("enter task ID to mark");
        int id= scanner.nextInt();

        String updateQuery= "update " + dBinfo.getTableName() +
                " set Done = ? where ID like " + id + ";";

        try {
            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, "√");

            preparedStatement.executeUpdate();

            dBinfo.closeConnection();

        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }
}

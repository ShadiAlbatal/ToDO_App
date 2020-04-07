package ToDo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditTaskDB {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public EditTaskDB() throws SQLException {
    }

    public void update() throws SQLException {
        dBinfo.useDB();
        System.out.println("enter task ID to update");
        int id= scanner.nextInt();
        System.out.println("enter new title");
        String newtitle= scanner.next();
        System.out.println("enter new due date");
        String newdate= scanner.next();
        System.out.println("enter new project");
        String newproject= scanner.next();

        String updateQuery= "update " + dBinfo.getTableName() + " set Title = ? , Due_Date = ?, Project = ? where ID like " + id + ";";


        try {
            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, newtitle);
            preparedStatement.setString(2,newdate);
            preparedStatement.setString(3,newproject);

            preparedStatement.executeUpdate();

            dBinfo.closeConnection();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

package ToDo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData_ps {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public InsertData_ps() throws SQLException {

    }

    public void insert() throws SQLException{

        System.out.println("enter Title");
        String title= scanner.next();
        System.out.println("enter Due Date accepted format is: yyyymmdd");
        String due_date= scanner.next();
        System.out.println("enter Project");
        String project= scanner.next();
        String done= "";

        String insertQuery= "insert into " + dBinfo.getTableName()  +
                "( Title, Due_Date, Project, Done ) values ( ?,?,?,?);";

        try {
            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(insertQuery);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2,due_date);
            preparedStatement.setString(3,project);
            preparedStatement.setString(4,done);

            preparedStatement.executeUpdate();

            dBinfo.closeConnection();

        }
        catch (SQLException s){
            s.printStackTrace();
        }


    }
}

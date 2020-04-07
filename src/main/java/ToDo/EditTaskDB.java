package ToDo;

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

        String updateQuery= "update " + dBinfo.getTableName() +
                " set Title = '" + newtitle +
                "' , Due_Date = '" + newdate +
                "' , Project = '" + newproject +
                "' where ID like " + id + ";";

        try {
            System.out.println("updating, Ya RB lka Alhamd");
            System.out.println(updateQuery);
            dBinfo.getStatement().executeUpdate(updateQuery);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(id + "Hasb ALLAH w nima Alwakil ,did not match any record");
        }
    }
}

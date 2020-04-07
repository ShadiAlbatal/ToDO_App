package ToDo;

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
        String sortproject= "select * from " + dBinfo.getTableName() + " order by Project";

        System.out.println("enter task ID to mark");
        int id= scanner.nextInt();

        String updateQuery= "update " + dBinfo.getTableName() +
                " set Done = '" + "√" +
                "' where ID like " + id + ";";

        try {
            System.out.println("marked, Ya RB lka Alhamd");
            System.out.println(updateQuery);
            dBinfo.getStatement().executeUpdate(updateQuery);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(id + "Hasb ALLAH w nima Alwakil ,did not match any record");
        }
    }
}

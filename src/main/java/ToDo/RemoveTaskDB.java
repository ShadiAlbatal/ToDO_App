package ToDo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveTaskDB {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public RemoveTaskDB() throws SQLException {
    }

    public void remove() throws SQLException {
        dBinfo.useDB();
        System.out.println("enter task ID to remove");
        int id= scanner.nextInt();

        String updateQuery= "delete from " + dBinfo.getTableName() +
                " where ID like " + id + ";";
        String getQuery= "select * from " + dBinfo.getTableName() + " where ID like '" + id + "';";

        try {
            ResultSet rs = dBinfo.getStatement().executeQuery(getQuery);
            System.out.println("are you sure want to delete the following:\n");
            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }
            System.out.println("\ny/n");
            String decition= scanner.next();
            switch (decition){
                case "y":
                    try {
                        System.out.println("deleted, Ya RB lka Alhamd");
                        System.out.println(updateQuery);
                        dBinfo.getStatement().executeUpdate(updateQuery);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        System.out.println(id + "Hasb ALLAH w nima Alwakil ,did not match any record");
                    }
                case "n":
                    break;
            }
        }
        catch (Exception c){
            c.printStackTrace();
        }

    }
}

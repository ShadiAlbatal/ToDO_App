package ToDo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertData {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public InsertData() throws SQLException {
    }


    public void insert() throws SQLException {

        System.out.println("enter Title");
        String title= scanner.next();
        System.out.println("enter Due Date accepted format is: yyyymmdd");
        String due_date= scanner.next();
        System.out.println("enter Project");
        String project= scanner.next();
        String done= "";


        String insertQuery= "insert into " + dBinfo.getTableName()  +
                "( Title, Due_Date, Project, Done ) values ( '" +
                title + "', " +
                due_date + ", '" +
                project + "', '" +
                done  + "'" +
                ");";


        try {
            // switching to the db
            System.out.println("switching db to: " + dBinfo.dbName);
            String useDbQuery= "use " + dBinfo.dbName;
            dBinfo.getStatement().executeUpdate(useDbQuery);
            System.out.println("Switched to "+ dBinfo.dbName + " ALHAMDuLLAH");

        }
        catch (Exception c){
            System.out.println("La houl wla quata Ila biLLAH, could not insert try again");
        }

        try {
            System.out.println(insertQuery);
            dBinfo.getStatement().executeUpdate(insertQuery);
            System.out.println("inserted, ALHMADuLLAH Rb ALalameen");
        }
        catch (Exception e){
            e.printStackTrace();
        }





    }

}

package ToDo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchDB {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public SearchDB() throws SQLException {
    }


    public void searchProject(){
        dBinfo.useDB();
        System.out.println("enter project name to search: ");
        String projectSearch= scanner.next();
        String searchProjectQuery= "select * from " + dBinfo.getTableName() + " where Project like ?;";
        System.out.println(searchProjectQuery);
        try {
            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(searchProjectQuery);
            preparedStatement.setString(1, projectSearch);
            ResultSet rs = dBinfo.getStatement().executeQuery(searchProjectQuery);

            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }

            System.out.println("SubhanAllah Rb Alalameen, finished project");
        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public void searchDueDate(){
        dBinfo.useDB();
        System.out.println("enter Due Date to search: ");
        String dueDateSearch= scanner.next();
        String searchDateQuery= "select * from " + dBinfo.getTableName() + " where Due_Date like ?;";
        System.out.println(searchDateQuery);
        try {
            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(searchDateQuery);
            preparedStatement.setString(1, dueDateSearch);
            ResultSet rs = dBinfo.getStatement().executeQuery(searchDateQuery);

            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }

            System.out.println("AlhmaduLLAH ,, finished due");
        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
            System.out.println(dueDateSearch + "not found,, La houl w la quta ila biLLAH");
        }
    }


    public void searchTitle(){
        dBinfo.useDB();
        System.out.println("ALHAMDuLLAH, search by title");
        System.out.println("enter Title to search: ");
        String titleSearch= scanner.next();
        String searchTitleQuery= "select * from " + dBinfo.getTableName() + " where Title like ?;";
        System.out.println(searchTitleQuery);
        try {

            PreparedStatement preparedStatement= dBinfo.getConnection().prepareStatement(titleSearch);
            preparedStatement.setString(1, titleSearch);
            ResultSet rs = dBinfo.getStatement().executeQuery(titleSearch);

            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);

            }

            System.out.println("finish search, TabarkaALLAH");
        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
            System.out.println("La houl w la quta ila biLLAH");
        }
    }


    public void search(){
        boolean flag= true;
        while (flag){
            System.out.println(
                    ">> (1) by title\n" +
                            ">> (2) by date\n" +
                            ">> (3) by project\n"+
                            ">> (00) back\n"

            );
            System.out.println("pick up a choice");
            int ch= scanner.nextInt();
            switch (ch){
                case 1:
                    searchTitle();
                    break;
                case 2:
                    searchDueDate();
                    break;
                case 3:
                    searchProject();
                case 00:
                    flag= false;
                    break;
            }
        }
    }
}

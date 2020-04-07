package ToDo;

import java.sql.*;
import java.util.Scanner;

public class SortDB {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public SortDB() throws SQLException {
    }

    public void sortProject(){
        dBinfo.useDB();
            String sortproject= "select * from " + dBinfo.getTableName() + " order by Project";
        try {

            ResultSet rs = dBinfo.getStatement().executeQuery(sortproject);

            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }

        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public void sortDueDate(){
        dBinfo.useDB();
            String sortduedate= "select * from " + dBinfo.getTableName() + " order by Due_Date";
            System.out.println("sort, ALHMADuLLAH Rb ALalameen");
            System.out.println("sort title, ALHMADuLLAH Rb ALalameen");

        try {

            ResultSet rs = dBinfo.getStatement().executeQuery(sortduedate);

            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done= rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }

        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }

    }


    public void sortTitle(){
        dBinfo.useDB();

            String sorttitle = "select * from " + dBinfo.getTableName() + " order by Title";
            System.out.println("sort, ALHMADuLLAH Rb ALalameen");
            try {

                ResultSet rs = dBinfo.getStatement().executeQuery(sorttitle);

                System.out.println("Title   Due_Date    Project    Done");
                while (rs.next()) {
                    String title = rs.getString("Project");
                    String due_date = rs.getString("Due_Date");
                    String project = rs.getString("Title");
                    String done= rs.getString("Done");
                    System.out.println(title + "   " + due_date + "    " + project + "    " + done);

                }

            } catch (SQLException e) {
                System.out.println("SQL exception occured" + e);
            }
        }


        public void sort(){
        boolean flag= true;
            while (flag){
                System.out.println(
                        ">> Search:\n" +
                                "(1) by title\n" +
                                ">> (2) by date\n" +
                                ">> (3) by project\n"+
                                ">> (00) back\n"

                );
                System.out.println("pick up a choice");
                int ch= scanner.nextInt();
                switch (ch){
                    case 1:
                        sortTitle();
                        break;
                    case 2:
                        sortDueDate();
                        break;
                    case 3:
                        sortProject();
                        break;
                    case 00:
                        flag= false;
                        break;
                }
            }
        }
    }

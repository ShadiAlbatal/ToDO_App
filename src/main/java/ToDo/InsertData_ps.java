package ToDo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData_ps {

    private DBinfo dBinfo= new DBinfo();
    private Scanner scanner= new Scanner(System.in);

    public InsertData_ps() throws SQLException {

    }

    public void insert() throws SQLException{

        System.out.println("enter task ID to remove");
        int id= scanner.nextInt();

        String getQuery= "select * from " + dBinfo.getTableName() + " where ID like ?;";
        String removeQuery= "delete from " + dBinfo.getTableName() + " where ID like ?;";

        try {
            PreparedStatement preparedStatementGet = dBinfo.getConnection().prepareStatement(getQuery);

            preparedStatementGet.setInt(1, id);
            ResultSet rs = preparedStatementGet.executeQuery();
            System.out.println("are you sure want to delete the following:\n");
            System.out.println("Title   Due_Date    Project    Done");
            while (rs.next()) {
                String title = rs.getString("Project");
                String due_date = rs.getString("Due_Date");
                String project = rs.getString("Title");
                String done = rs.getString("Done");
                System.out.println(title + "   " + due_date + "    " + project + "    " + done);
            }
            System.out.println("\ny/n");
            String decition = scanner.next();
            switch (decition) {
                case "y":
                    try {
                        PreparedStatement preparedStatementRemove = dBinfo.getConnection().prepareStatement(removeQuery);
                        preparedStatementRemove.setInt(1, id);

                        preparedStatementRemove.executeUpdate();

                        dBinfo.closeConnection();

                    } catch (SQLException s) {
                        s.printStackTrace();
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

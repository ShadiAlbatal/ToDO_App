package ToDo;

import java.sql.SQLException;

public class CreateDB  {

    DBinfo infoDB= new DBinfo();

    public CreateDB() throws SQLException {
    }

    public void createDB(){
        System.out.println("creating the db");
        String dbName= infoDB.getDbName();
        String tableName= infoDB.getTableName();

        try {
            // register JDBC dirver
            Class.forName(infoDB.getJdbc_driver());
            System.out.println("connecting to server");

            // open connection
            infoDB.getConnection();

            // creating DB
            try {
                String dbCreateQuery= "CREATE DATABASE IF NOT EXISTS " + dbName + ";";
                infoDB.getStatement().executeUpdate(dbCreateQuery);
                System.out.println(dbName +" db was created, ALHAMDuLLAH");
            }
            catch (Exception x){
                x.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            // switching to the db
            System.out.println("switching db to: " + dbName);
            String useDbQuery= "use " + dbName;
            infoDB.getStatement().executeUpdate(useDbQuery);
            System.out.println("Switched to "+ dbName + " ALHAMDuLLAH");

        }
        catch (Exception c){
            c.printStackTrace();
        }

        try {
            // creating table
            System.out.println("creating table: " + tableName);
            String createTableQuery= "CREATE TABLE IF NOT EXISTS " + tableName + "(\n" +
                    "   ID int auto_increment,\n" +
                    "   Title varchar(50),\n" +
                    "   Due_Date DATE,\n" +
                    "   Project varchar(50),\n" +
                    "   Done varchar(20),\n" +
                    "   primary key (ID));";
             infoDB.getStatement().executeUpdate(createTableQuery);
            System.out.println("created table "+ tableName + " LLAhiLHMD");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

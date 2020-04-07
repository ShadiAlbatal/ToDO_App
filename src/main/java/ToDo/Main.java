package ToDo;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static private Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
	// write your code here
        CreateDB createDB= new CreateDB();
        createDB.createDB();

        boolean flag= true;
        while (flag){
            System.out.println(">> Welcome to ToDoLy\n" +
                    ">> You have X tasks todo and Y tasks are done!\n" +
                    ">> Pick an option:\n" +
                    ">> (1) Add New Task\n" +
                    ">> (2) Show Task List (by date or project or by title)\n" +
                    ">> (3) search Task (by date or project or by title)\n" +
                    ">> (4) Edit Task (update, mark as done, remove)\n" +
                    ">> (5) Save and Quit");

            System.out.println("enter choice");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    InsertData_ps InsertData_ps= new InsertData_ps();
                    InsertData_ps.insert();
                    break;
                case 2:
                    SortDB sortDB = new SortDB();
                    sortDB.sort();
                    break;
                case 3:
                    SearchDB searchDB= new SearchDB();
                    searchDB.search();
                case 4:
                    UpdateDB updateDB= new UpdateDB();
                    updateDB.update();

                case 5:
                    flag= false;
                    break;
            }
        }

    }


}
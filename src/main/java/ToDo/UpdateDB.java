package ToDo;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDB {

    private Scanner scanner= new Scanner(System.in);

    public void update() throws SQLException {

        boolean flag= true;
        while (flag) {
            System.out.println("select actions");
            System.out.println(
                    ">>Actions:\n" +
                            ">> (1) Update task\n" +
                            ">> (2) mark as done\n" +
                            ">> (3) remove\n" +
                            ">> (00) back\n"
            );
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    EditTaskDB editTaskDB = new EditTaskDB();
                    editTaskDB.update();
                    break;
                case 2:
                    MarkTaskDB markTaskDB= new MarkTaskDB();
                    markTaskDB.Mark();
                case 3:
                    RemoveTaskDB removeTaskDB= new RemoveTaskDB();
                    removeTaskDB.remove();
            }
        }
    }
}

import java.util.Date;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            int menu = mainMenu();
            if(menu == 1 || menu == 2){
                listmenu(menu);
            }
            if ((menu != 1) && (menu != 2) && (menu != 3)){System.out.println("Invalid response. Try again.");}
            if(menu ==3){break;}
        }
    }

    private static int mainMenu() {
        System.out.println("\nMain Menu\n" +
                "---------\n\n" +"1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n\n>");
        return input.nextInt();
    }

    private static int listMenuresponse() {
        System.out.println("\nList Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n" +
                "\n" +
                ">");
        return input.nextInt();
    }

    private static void listmenu(int menu){
        int listmenu = 0;
        TaskList taskList = new TaskList();
        if (menu == 2){
            System.out.println("Enter the filename to load:");
            taskList.inport(input.next());
            System.out.println("task list has been loaded");
        }
        else {
            System.out.println("new task list has been created");
        }
        while (listmenu !=8) {
            listmenu = listMenuresponse();

            switch (listmenu) {
                case 1:
                    taskList.list();
                    break;
                case 2:
                    taskList.add();
                    break;
                case 3:
                    taskList.list();
                    System.out.println("Which task will you edit?");
                    taskList.edit(input.nextInt());
                    break;
                case 4:
                    taskList.list();
                    System.out.println("Which task will you remove?");
                    taskList.remove(input.nextInt());
                    break;
                case 5:
                    taskList.printuncompleted();
                    System.out.println("Which task will you mark as completed?");
                    taskList.mark(input.nextInt());
                    break;
                case 6:
                    taskList.printcompleted();
                    System.out.println("Which task will you unmark as completed?");
                    taskList.unmark(input.nextInt());
                    break;
                case 7:
                    System.out.println("Enter the filename to save as: ");
                    taskList.save(input.next());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }
}

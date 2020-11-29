import java.util.Scanner;

public class TaskApp {
    private static final Scanner taskinput = new Scanner(System.in);
    private static TaskList taskList = new TaskList();
    public static void main() {
        int menu = -1;
        while(menu != 3){
            menu = mainMenu();
            switch (menu){
                case 1 :
                    taskList = new TaskList();
                    System.out.println("new task list has been created");
                    listmenu();
                    break;
                case 2 :
                    taskList = new TaskList();
                    System.out.println("Enter the filename to load:");
                    taskList.inport(taskinput.next());
                    System.out.println("task list has been loaded");
                    listmenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }

    private static int mainMenu() {
        System.out.println("\nMain Menu\n" +
                "---------\n\n" +"1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n\n>");
        return taskinput.nextInt();
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
        return taskinput.nextInt();
    }

    private static void listmenu(){
        int listmenu = 0;
        while (listmenu !=8) {
            listmenu = listMenuresponse();
            switch (listmenu) {
                case 1:
                    taskList.list();
                    break;
                case 2:
                    addtask();
                    break;
                case 3:
                    edittask();
                    break;
                case 4:
                    taskList.list();
                    System.out.println("Which task will you remove?");
                    taskList.remove(taskinput.nextInt());
                    break;
                case 5:
                    taskList.printuncompleted();
                    System.out.println("Which task will you mark as completed?");
                    taskList.mark(taskinput.nextInt());
                    break;
                case 6:
                    taskList.printcompleted();
                    System.out.println("Which task will you unmark as completed?");
                    taskList.unmark(taskinput.nextInt());
                    break;
                case 7:
                    System.out.println("Enter the filename to save as: ");
                    taskList.save(taskinput.next());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }

    private static void addtask() {
        System.out.print("Task title:");
        String title = taskinput.nextLine();
        System.out.print("Task description:");
        String description =  taskinput.nextLine();
        System.out.print("Task due date (YYYY-MM-DD):");
        String date = taskinput.nextLine();
        taskList.add(title,description,date);
    }

    private static void edittask() {
        taskList.list();
        System.out.println("Which task will you edit?");
        int index = taskinput.nextInt();
        taskinput.nextLine();
        System.out.print("\nEnter a new title for task " + index +": ");
        String title1 = taskinput.nextLine();
        System.out.print("Enter a new description for task " + index +": ");
        String description2 =  taskinput.nextLine();
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index +": ");
        String date3 = taskinput.nextLine();
        taskList.edit(title1,description2,date3,index);
    }
}

import java.util.Scanner;

public class ContactApp{
    private static Scanner contactinput = new Scanner(System.in);
    private static ContactList contactList = new ContactList();

    public static void main() {
        taskapp:
        while(true){
            int menu = mainMenu();
            switch (menu){
                case 1 :
                    contactList = new ContactList();
                    System.out.println("new contact list has been created");
                    listmenu();
                    break;
                case 2 :
                    contactList = new ContactList();
                    System.out.println("Enter the filename to load:");
                   // contactList.inport(input.next());
                    System.out.println("task list has been loaded");
                    listmenu();
                    break;
                case 3:
                    break taskapp;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }

    private static void listmenu(){
        int listmenu = 0;
        while (listmenu !=8) {
            listmenu = listMenuresponse();
            contactinput.nextLine();
            switch (listmenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }

    private static int listMenuresponse() {
        System.out.println("\nList Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n" +
                "\n" +
                "> ");
        return contactinput.nextInt();

    }

    private static int mainMenu() {
        System.out.println("\nMain Menu\n" +
                "---------\n\n" +"1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n\n>");
        return contactinput.nextInt();
    }

}

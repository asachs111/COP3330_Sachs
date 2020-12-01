import java.util.Scanner;

public class ContactApp{
    private static final Scanner contactinput = new Scanner(System.in);
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
                    System.out.println("Contact list has been loaded");
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
        while (listmenu !=6) {
            listmenu = listMenuresponse();
            contactinput.nextLine();
            switch (listmenu) {
                case 1:
                    contactList.view();
                    break;
                case 2:
                    addcontact();
                    break;
                case 3:
                    editcontact();
                    break;
                case 4:
                    removecontact();
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

    private static void removecontact() {
        if (contactList.size() == 0){
            System.out.println("you have no tasks to remove");
        } else {
            contactList.view();
            System.out.println("\nWhich contact will you remove?");
            int index = contactinput.nextInt();
            contactinput.nextLine();
            contactList.remove(index);
        }
    }

    private static void addcontact() {
        System.out.print("First name:");
        String Firstname = contactinput.nextLine();
        System.out.print("Last name:");
        String Lastname = contactinput.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx):");
        String phone = contactinput.nextLine();
        System.out.print("Email address (x@y.z):");
        String email = contactinput.nextLine();
        contactList.add(Firstname,Lastname,phone,email);
    }

    private static void editcontact() {
        if (contactList.size() == 0){
            System.out.println("you have no tasks to edit");
        } else {
            contactList.view();
            System.out.println("\nWhich contact will you edit?");
            int index = contactinput.nextInt();
            contactinput.nextLine();
            System.out.print("Enter a new first name for contact " + index + ":");
            String Firstname = contactinput.nextLine();
            System.out.print("Enter a new last name for contact " + index + ":");
            String Lastname = contactinput.nextLine();
            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ":");
            String phone = contactinput.nextLine();
            System.out.print("Enter a new email address (x@y.z) for contact" + index + ":");
            String email = contactinput.nextLine();
            contactList.edit(index, Firstname, Lastname, phone, email);
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

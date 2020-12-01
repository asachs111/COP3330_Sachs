import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList extends UserLists {
    private ArrayList<Contactitem> contactlist = new ArrayList<>();
    public ContactList(){}

    public int size() {
        return contactlist.size();
    }
    public item get(int index) {
        return contactlist.get(index);
    }
    public void remove(int index) {
        contactlist.remove(index);
    }
    public void view() {
        System.out.println("Current Contacts\n" +
                "-------------\n");
        for (int i = 0;i<contactlist.size();i++){
            System.out.println(i + ") " + contactlist.get(i).toString());
        }
    }
    public void add(String Firstname,String Lastname,String Phone, String email){
        try {
            Contactitem ct = new Contactitem(Firstname,Lastname,Phone,email);
            contactlist.add(ct);
        } catch (Minimumfieldsnotmet ex){
            System.out.println("At least one field must be populated to create a contact");
        } catch (Invalidemail ex){
            System.out.println("You entered an invalid email. Contact not created");
        } catch (Invalidphone ex){
            System.out.println("You entered an invalid Phone Number. Contact not created");
        }
    }

    public void edit(int index, String Firstname, String Lastname, String Phone, String email) {
        try {
            Contactitem ct = new Contactitem(Firstname,Lastname,Phone,email);
            contactlist.set(index,ct);
        } catch (Minimumfieldsnotmet ex){
            System.out.println("At least one field must be populated to create a contact");
        } catch (Invalidemail ex){
            System.out.println("You entered an invalid email. Contact not created");
        } catch (Invalidphone ex){
            System.out.println("You entered an invalid Phone Number. Contact not created");
        }
    }
    public void save(String filename){
        try(Formatter output = new Formatter(filename)) {
            output.format(contactlist.size()+ "\n");
            for(int i = 0; i < contactlist.size(); i++) {
                output.format(contactlist.get(i).ezFormat());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("task list has been saved");

    }

    public void inport(String next) {
        try {
            File myObj = new File(next);
            Scanner myReader = new Scanner(myObj);
            int tasks = Integer.parseInt(myReader.nextLine());
            for (int i = 0 ; i< tasks;i++) {
                String Firstname =myReader.nextLine();
                String Lastname =myReader.nextLine();
                String Phone = myReader.nextLine();
                String email = myReader.nextLine();
                contactlist.add(new Contactitem(Firstname,Lastname,Phone,email));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception | Minimumfieldsnotmet | Invalidemail | Invalidphone e) {
            System.out.println("Your file does not contain contacts");
        }
    }
}

import java.util.ArrayList;

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
}

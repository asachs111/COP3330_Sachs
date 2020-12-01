import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertEquals(1,contactList.size());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){
            ContactList contactList = new ContactList();
            contactList.add("","","","");
            assertEquals(0,contactList.size());
    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertThrows(IndexOutOfBoundsException.class, () -> contactList.edit(3,"Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu"));
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertDoesNotThrow(() ->contactList.edit(0,"","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu"));
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertDoesNotThrow(() ->contactList.edit(0,"","","","woudntyouliketoknow@knights.ucf.edu"));
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertDoesNotThrow(() ->contactList.edit(0,"","","","woudntyouliketoknow@knights.ucf.edu"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertDoesNotThrow(() ->contactList.edit(0,"LEroy","or something","888-888-8888","woudntyouliketoknow@knights.ucf.edu"));
    }
    @Test
    public void newListIsEmpty(){
        ContactList contactList = new ContactList();
        assertEquals(0,contactList.size());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        int presize = contactList.size();
        contactList.remove(0);
        assertTrue(presize>contactList.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList contactList = new ContactList();
        contactList.add("Adam","Sachs","999-999-9999","woudntyouliketoknow@knights.ucf.edu");
        assertThrows(IndexOutOfBoundsException.class, () -> contactList.remove(1));
    }
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contactList = new ContactList();
        assertDoesNotThrow(() -> contactList.inport("contacts.txt"));
    }
}
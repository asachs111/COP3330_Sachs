import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactitemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(Minimumfieldsnotmet.class,() -> new Contactitem("","","",""));
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new Contactitem("","dean","",""));
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new Contactitem("Adam","Sachs","999-999-9999","a@sachs.com"));
    }
    @Test
    public void editingFailsWithAllBlankValues(){
        assertThrows(Minimumfieldsnotmet.class,() -> new Contactitem("","","",""));
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new Contactitem("","dean","",""));
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new Contactitem("Adam","","",""));
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new Contactitem("Adam","Sachs","999-999-9999","a@sachs.com"));
    }
    @Test
    public void testToString() throws Invalidphone, Minimumfieldsnotmet, Invalidemail {
        Contactitem ci = new Contactitem("Adam","","","");
        assertEquals("Name: Adam  \n" +
                "Phone:  \n" +
                "Email:  ",ci.toString());
    }
    @Test
    public void testezFormat() throws Invalidphone, Minimumfieldsnotmet, Invalidemail {
        Contactitem ci = new Contactitem("Adam","","","");
        assertEquals("",ci.ezFormat());
    }
}
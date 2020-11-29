public class Contactitem extends item{
    private String Firstname;
    private String Lastname;
    private String Phone;
    private String email;
    public Contactitem(String Firstname,String Lastname,String Phone,String email){
        this.Firstname=Firstname;
        this.Lastname=Lastname;
        this.Phone=Phone;
        this.email=email;
    }
    public String toString() {
        return ("Name: " + this.Firstname +" "+ this.Lastname +
                "\nPhone: " + this.Phone +
                "\nEmail: " + this.email);
    }

    public String ezFormat() {
        return null;
    }
}
//Check all fields to make sure something is filled before validating any fields and throw a Minnimum items not met error
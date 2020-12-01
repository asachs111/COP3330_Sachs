public class Contactitem extends item{
    private String Firstname;
    private String Lastname;
    private String Phone;
    private String email;

    public Contactitem(String Firstname,String Lastname,String Phone,String email) throws Minimumfieldsnotmet, Invalidemail, Invalidphone {
        if (arefieldsallempty(Firstname,Lastname,Phone,email)){
            throw new Minimumfieldsnotmet();
        } else {
            if(!Firstname.isEmpty()){
                setfirstname(Firstname);
            }else {this.Firstname = " ";}
            if(!Lastname.isEmpty()){
                setlastname(Lastname);
            }else {this.Lastname = " ";}
            if(!Phone.isEmpty()){
                setphone(Phone);
            }else {this.Phone = " ";}
            if(!email.isEmpty()){
                setemail(email);
            } else {this.email = " ";}
        }

    }

    public void setemail(String validate) throws Invalidemail {

        if(validate.equals(" ")){
            this.email = validate;
        } else {
            if (validate.contains("@") && validate.contains(".")) {
                String preat = validate.substring(0, validate.indexOf('@'));
                String postat = validate.substring(validate.indexOf('@') + 1);
                if (preat.isEmpty() || !postat.contains(".") || postat.substring(postat.indexOf('.')).isEmpty()) {
                    throw new Invalidemail();
                }
                this.email = validate;
            } else {
                throw new Invalidemail();
            }
        }
    }

    public void setphone(String validate) throws Invalidphone {
        if(validate.equals(" ")){
            this.Phone = validate;
        } else {
            if (validate.length() != 12 && validate.charAt(3) == '-' && validate.charAt(7) == '-') {
                throw new Invalidphone();
            }
            try {
                int a = Integer.parseInt(validate.substring(0, 3));
                int b = Integer.parseInt(validate.substring(4, 7));
                int c = Integer.parseInt(validate.substring(8, 12));
                a = a + b + c;
            } catch (Exception ex) {
                throw new Invalidphone();
            }
        }
        this.Phone=validate;
    }

    public void setlastname(String validate) {
        this.Lastname=validate;
    }

    public void setfirstname(String validate) {
        this.Firstname=validate;
    }

    private boolean arefieldsallempty(String Firstname,String Lastname,String Phone,String email) {
        String a =Firstname+Lastname+Phone+email;
        return a.isEmpty();

    }
    @Override
    public String toString() {
        return ("Name: " + this.Firstname +" "+ this.Lastname +
                "\nPhone: " + this.Phone +
                "\nEmail: " + this.email);
    }

    public String ezFormat() {
        return Firstname + "\n" + Lastname+ "\n" +Phone+ "\n" +email+ "\n";
    }
}




class Minimumfieldsnotmet extends Throwable {
    public Minimumfieldsnotmet() {
        super();
    }
}
class Invalidemail extends Throwable {
    public Invalidemail() {
        super();
    }
}
class Invalidphone extends Throwable {
    public Invalidphone() {
        super();
    }
}
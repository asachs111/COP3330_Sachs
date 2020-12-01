import java.util.Date;

public class TaskItem extends item{
    private String title;
    private String description;
    private Date date;
    private boolean completed;

    public TaskItem(String title, String description, String date) throws InvalidtitleException, InvaliddiscriptionException, InvaliddateException {


        if(validtitle(title)) {
            this.title = title;
        } else {
            throw new InvalidtitleException("WARNING: title must be at least 1 character long; task not created");
        }
        if(validdescription(description)) {
            this.description = description;
        } else {
            throw new InvaliddiscriptionException("WARNING: discription must be at least 1 character long; task not created");
        }
        try {
            int year =Integer.parseInt(date.substring(0, 4))-1900;
            int month = Integer.parseInt(date.substring(5, 7))-1;
            int day = Integer.parseInt(date.substring(8, 10));
            Date date1 = new Date( year, month, day);
            this.date = date1;
        } catch (NumberFormatException ex){
            throw new InvaliddateException("WARNING: Invalid date input; task not created");
        }
        this.completed = false;
    }

    //prevalidated inputs (inport)
    public TaskItem(String title, String description, Date date, String bool){
        this.title = title;
        this.description = description;
        this.date = date;
        this.completed = bool.equals("***");
    }

    private boolean validtitle(String title){
        return title.length() >= 1;
    }

    private boolean validdescription(String description){
        return description.length() >= 0;
    }

    public void settitle(String title) throws InvalidtitleException {
        if(validtitle(title)) {
            this.title = title;
        } else {
            throw new InvalidtitleException("WARNING: title must be at least 1 character long; task not edited");
        }
    }

    public void setdiscription(String description) throws InvaliddiscriptionException {
        if(validdescription(description)) {
            this.description = description;
        } else {
            throw new InvaliddiscriptionException("WARNING: discription must be at least 1 character long; task not created");
        }
    }

    public void setDate(String date) throws InvaliddateException {
        try {
            int year =Integer.parseInt(date.substring(0, 4))-1900;
            int month = Integer.parseInt(date.substring(5, 7))-1;
            int day = Integer.parseInt(date.substring(8, 10));
            Date date1 = new Date( year, month, day);
            this.date = date1;
        } catch (NumberFormatException ex){
            throw new InvaliddateException("WARNING: Invalid date input; task not created");
        }
    }

    public void setCompleted(boolean state){
        completed = state;
    }

    public boolean getCompleted(){
        return completed;
    }

    public String ezFormat(){
        return (title + "\n" + description + "\n" + ezdate() + "\n" + complete() + "\n");
    }

    public String ezdate(){
        return date.getYear() + " " + date.getMonth() + " " + date.getDate();
    }

    public String complete(){
        if(completed){
            return "***";
        } else {
            return "";
        }
    }

    @Override
    public String toString(){
        return (" ["+ (date.getYear()+1900)+ "-" + (date.getMonth()+1) + "-" + date.getDate() + "] " + this.title + ": "+ this.description);
    }

    public String gettitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}

















class InvalidtitleException extends Throwable {
    public InvalidtitleException(String s) {
        super(s);
    }
}
class InvaliddiscriptionException extends Throwable {
    public InvaliddiscriptionException(String s) {
        super(s);
    }
}
class InvaliddateException extends Throwable {
    public InvaliddateException(String s) {
        super(s);
    }
}
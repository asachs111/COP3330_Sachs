import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    private ArrayList<TaskItem> TaskList = new ArrayList<>();

    public TaskList(){}
    public TaskItem get(int index){
        return TaskList.get(index);
    }
    public void add(String title, String description, String date) {
        try{
            TaskItem task = new TaskItem(title,description,date);
            TaskList.add(task);
        } catch (InvalidtitleException ex){
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (InvaliddiscriptionException ex){
            System.out.println("WARNING: description must be at least 1 character long; task not created");
        } catch (InvaliddateException ex){
            System.out.println("WARNING: Date must follow format; task not created");
        }
    }

    public void list() {
        System.out.println("Current Tasks\n" +
                "-------------\n");
        for (int i = 0;i<TaskList.size();i++){
            System.out.println(i + ") " + TaskList.get(i).complete() + TaskList.get(i).toString());
        }
    }

    public void remove(int index) {
        try {
            TaskList.remove(index);
        } catch (Exception ex){
            System.out.println("Something went wrong. make sure to select a valid task to remove");
        }
    }

    public void edit(String title, String description, String date,int index) {
        try{
            TaskList.get(index).settitle(title);
            TaskList.get(index).setdiscription(description);
            TaskList.get(index).setDate(date);
        } catch (InvalidtitleException ex){
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (InvaliddiscriptionException ex){
            System.out.println("WARNING: description must be at least 1 character long; task not created");
        } catch (InvaliddateException ex){
            System.out.println("WARNING: Date must follow format; task not created");
        } catch (IndexOutOfBoundsException ex){
            System.out.println("Something went wrong. make sure to select a valid task");
        }
    }

    public void mark(int i) {
        try {
            TaskList.get(i).setCompleted(true);
        } catch (Exception ex){
            System.out.println("Something went wrong. make sure to select a valid task");
        }
    }

    public void unmark(int i) {
        try {
            TaskList.get(i).setCompleted(false);
        } catch (Exception ex){
            System.out.println("Something went wrong. make sure to select a valid task");
        }
    }

    public void printuncompleted() {
        System.out.println("Uncompleted Tasks\n" +
                "-------------\n");
        for (int i = 0;i<TaskList.size();i++){
            if(!TaskList.get(i).getCompleted())
            System.out.println(i + ") " + TaskList.get(i).toString());
        }
    }

    public void printcompleted() {
        System.out.println("Uncompleted Tasks\n" +
                "-------------\n");
        for (int i = 0;i<TaskList.size();i++){
            if(TaskList.get(i).getCompleted())
                System.out.println(i + ") " + TaskList.get(i).toString());
        }
    }

    public void save(String filename) {
        try(Formatter output = new Formatter(filename)) {
            output.format(TaskList.size()+ "\n");
            for(int i = 0; i < TaskList.size(); i++) {
                TaskItem data = TaskList.get(i);
                output.format(TaskList.get(i).ezFormat());
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
                                    String titlea =myReader.nextLine();
                                    String discriptiona =myReader.nextLine();
                                    int year = myReader.nextInt();
                                    int month = myReader.nextInt();
                                    int date = myReader.nextInt();
                                    myReader.nextLine();
                                    String complete = myReader.nextLine();
                TaskList.add(new TaskItem(titlea,discriptiona,new Date(year,month,date),complete));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int size(){return TaskList.size();}
}

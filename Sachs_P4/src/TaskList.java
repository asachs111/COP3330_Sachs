import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> TaskList = new ArrayList<>();

    public TaskList(){}
    public void newlist(){}

    public void load(){

    }

    public void add() {
        try{
            System.out.print("Task title:");
            String title = input.nextLine();
            System.out.print("Task description:");
            String description =  input.nextLine();
            System.out.print("Task due date (YYYY-MM-DD):");
            String date = input.nextLine();
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
        TaskList.remove(index);
    }

    public void edit(int index) {
        list();
        try{
            System.out.print("\nEnter a new title for task " + index +": ");
            String title = input.nextLine();
            System.out.print("Enter a new description for task " + index +": ");
            String description =  input.nextLine();
            System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index +": ");
            String date = input.nextLine();
            TaskList.get(index).settitle(title);
            TaskList.get(index).setdiscription(description);
            TaskList.get(index).setDate(date);
        } catch (InvalidtitleException ex){
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (InvaliddiscriptionException ex){
            System.out.println("WARNING: description must be at least 1 character long; task not created");
        } catch (InvaliddateException ex){
            System.out.println("WARNING: Date must follow format; task not created");
        }
    }

    public void mark(int i) {
        TaskList.get(i).setCompleted(true);
    }

    public void unmark(int i) {
        TaskList.get(i).setCompleted(false);
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
                TaskList.add(new TaskItem(myReader.nextLine(),myReader.nextLine()
                        ,new Date(Integer.parseInt(myReader.next()),Integer.parseInt(myReader.next()),Integer.parseInt(myReader.next()))
                        ,myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public int size(){return TaskList.size();}
}

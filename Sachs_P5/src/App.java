import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int app = -1;
        done:
        while(app != 3) {
            app =appselector();
            switch (app) {
                case 1:
                    TaskApp.main();
                    break;
                case 2:
                    ContactApp.main();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }

    private static int appselector() {
        System.out.println("Select Your Application\n" +
                "-----------------------\n" +
                "\n" +
                "1) task list\n" +
                "2) contact list\n" +
                "3) quit\n\n>");
        int ret = input.nextInt();
        input.nextLine();
        return ret;
    }
}

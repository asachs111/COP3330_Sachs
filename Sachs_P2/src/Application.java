import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        Scanner input = new Scanner(System.in);
        String response;
        while(true){
            System.out.println("Would you like to add a users bmi data? (Y/N)");
            response = input.next();
            if (response.length() != 1){
                System.out.println("Please enter a valid response");
            }
            else if (response.charAt(0) == 'Y'){
                return true;
            }
            else if (response.charAt(0) == 'N'){
                return false;
            }
        }
        
    }

    public static double getUserHeight(){
        Scanner input = new Scanner(System.in);
        double retval = -1;
        while (retval <= 0){
            System.out.println("Please enter the users height in inches");
            retval = input.nextDouble();
            input.nextLine();
        }
        return retval;
    }

    public static double getUserWeight(){
        Scanner input = new Scanner(System.in);
        double retval = -1;
        while (retval <= 0){
            System.out.println("Please enter the users weight in pounds");
            retval = input.nextDouble();
            input.nextLine();
        }
        return retval;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("With the data you just input the member has a bmi of " + bmi.bmi + ". This is Categorized as" + bmi.Category(bmi.bmi));
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double average = 0;
        for (int i=0; i<bmiData.size() ;i++){
            average += bmiData.get(i).bmi;
        }
        average = average / bmiData.size();
        if (bmiData.size() == 0){average = 0;}
        System.out.println("the average bmi for the data you entered is " + Math.round(average * 100.0) / 100.0) ;

    }
}
public class BodyMassIndex {
    double height;
    double weight;
    double bmi;

    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
        this.bmi = Math.round((703 * weight)/(height * height) * 100.0) / 100.0;
    }


    public String Category(double bmi){
        if (bmi < 18.5){
            return " Underweight.";
        }
        else if (bmi < 25){
            return " Normal weight.";
        }
        else if (bmi < 30){
            return " Overweight.";
        }
        else {
            return " Obesity.";
        }
    }











}

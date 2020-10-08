import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BodyMassIndexTest {
    @Test
    public void testBmiCategoryUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,18);
        assertEquals(" Underweight.", bmi.Category(bmi.bmi));
    }

    @Test
    public void testBmiCategoryNormalweightlow(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,18.5);
        assertEquals(" Normal weight.", bmi.Category(bmi.bmi));
    }
    @Test
    public void testBmiCategoryNormalweighthigh(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,24.9);
        assertEquals(" Normal weight.", bmi.Category(bmi.bmi));
    }

    @Test
    public void testBmiCategoryOverweightlow(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,25);
        assertEquals(" Overweight.", bmi.Category(bmi.bmi));
    }
    @Test
    public void testBmiCategoryOverweighthigh(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,29.9);
        assertEquals(" Overweight.", bmi.Category(bmi.bmi));
    }

    @Test
    public void testBmiCategoryObesitylow(){
        BodyMassIndex bmi = new BodyMassIndex(26.514,31);
        assertEquals(" Obesity.", bmi.Category(bmi.bmi));
    }

}
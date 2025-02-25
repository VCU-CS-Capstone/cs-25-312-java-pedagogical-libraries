package sampleSubmissions.Lab03CorrectBoolean;

/**
 * Correct...but booleans and scientific notation need to be tested
 */
public class VariableDefinitions {
    public static void main(String[] args) {
        // initial declaration of fingers variable
        byte fingers = 10;
        // initial declaration of temperature variable
        float temperature = 60.0F;
        //initial declaration of area variable
        double area = 105.5;
        //initial declaration of funnyNumber variable
        int funnyNumber = 42069;
        System.out.println("The fingers variable has a value of " + fingers);
        System.out.println("The temperature variable has a value of " + temperature);
        System.out.println("The area variable has a value of " + area);
        System.out.println("The funnyNumber variable has a value of " + funnyNumber);
        //modified value of the fingers value
        fingers = 9;
        //modified value of the temperatue value
        temperature = 32.05F;
        //modified value of the area value
        area = 123239995.34;
        //modified value of the funnyNumber value
        funnyNumber = 0;
        System.out.println("The fingers variable now has a value of " + fingers);
        System.out.println("The temperature variable now has a value of " + temperature);
        System.out.println("The area variable now has a value of " + area);
        System.out.println("The funnyNumber variable now has a value of " + funnyNumber);
        //initial declaration of DAYTIME constant
        final boolean DAYTIME = false;
        //initial declaration of LONGNUMBER constant
        final long LONGNUMBER = 123456789;
        //initial declaration of SHORTNUMBER constant
        final short SHORTNUMBER = 1234;
        //initial declaration of SOMETHING constant
        final char SOMETHING = 'A';
        System.out.println("The DAYTIME constant has a value of " + DAYTIME);
        System.out.println("The LONGNUMBER constant has a value of " + LONGNUMBER);
        System.out.println("The SHORTNUMBER constant has a value of " + SHORTNUMBER);
        System.out.println("The SOMETHING constant has a value of " + SOMETHING);
        //DAYTIME = true;
    }
}
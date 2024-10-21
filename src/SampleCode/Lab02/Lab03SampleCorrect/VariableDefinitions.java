package sampleSubmissions.Lab03SampleCorrect;


/**
 * Actually correct, note the extra 0 in total is intentional
 */
public class VariableDefinitions {
    public static void main(String[] args) {
        // Initial declaration of the count variable
        int count = 42;
        // Initial declaration of the total variable
        double total = 34.00;//extra 0 is intentional
        // Initial declaration of numPeople variable
        byte numPeople = 40;
        // Initial declaration of the reallyBigNumber variable
        long reallyBigNumber = 12947711080L;

        System.out.println("The int count variable has a value of " + count);
        System.out.println("The double total variable has a value of " + total);
        System.out.println("The Long reallyBigNumber variable has a value of " + reallyBigNumber);
        System.out.println("The numPeople variable has a value of " + numPeople);

        // modified value of the int count variable
        count = 8;
        // modified value of the double total variable
        total = 13.0;
        // modified value of the numPeople variable
        numPeople = 6;
        // modified value of the long reallyBigNumber variable
        reallyBigNumber = 704556778L;

        System.out.println("The int count variable now has a value of " + count);
        System.out.println("The double total variable now has a value of " + total);
        System.out.println("The Long reallyBigNumber variable now has a value of " + reallyBigNumber);
        System.out.println("The numPeople variable now has a value of " + numPeople);
        // inital declaration of count constant
        final int count3 = 41;
        // inital declaration of double total constant
        final double total3 = 78.1;
        // inital declaration of numPeople constant
        final byte numPeople3 = 121;
        // inital declaration of reallyBigNumber constant
        final long reallyBigNumber3 = 454242424L;
        System.out.println("The int count variable has a value of " + count3);
        System.out.println("The double total variable has a value of " + total3);
        System.out.println("The Long reallyBigNumber variable has a value of " + reallyBigNumber3);
        System.out.println("The numPeople variable has a value of " + numPeople3);
        //Compilation error
        //final int count = 5;
        //Compilation error
        //final double total =87;
        //Compilation error
        //final byte numPeople =99;
        //Compilation error
        //final long reallyBigNumber = 50;
    }
}
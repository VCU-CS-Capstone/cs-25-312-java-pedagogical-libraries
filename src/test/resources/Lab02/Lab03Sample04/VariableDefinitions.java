package sampleSubmissions.Lab03Sample04;

/**
 * Ostensibly correct solution, but the print statements aren't grouped together.
 */
public class VariableDefinitions {
    public static void main(String[] args) {

        //initial declaration of  priceItem variable
        double itemPrice = 32.32;
        System.out.println(" The itemPrice variable has a value of" + itemPrice);

        //initial declaration of  int classNum variable
        int classNum = 207;
        System.out.println(" The classNum variable has a value of " + classNum);

        //initial declaration of long numL variable
        long numL = 9901234556789L;
        System.out.println(" The long numL variable is " + numL);

        //initial declaration of int smallNum variable
        short numS = 17760;
        System.out.println(" The numS variable is " + numS);

        //modified value of the priceItem variable
        itemPrice = 45.45;
        System.out.println(" The itemPrice variable now has a value of" + itemPrice);

        //modified value of the classNum variable
        classNum = 210;
        System.out.println(" The classNum variable now has a value of " + classNum);

        //modified value of the bigNum variable
        numL = 23458899949443L;
        System.out.println(" The long numL variable now is " + numL);

        //modified value of the  numS variable
        numS = 17800;
        System.out.println(" The smallNum variable now is " + numS);


        //declaring and intitalizing four constants

        final float temperatureReading = 85.0F;
        System.out.println(" The constant variable temperatureReading value is  " + temperatureReading);

        final short littleNum = 32000;
        System.out.println(" The constant variable littleNum value is " + littleNum);

        final byte numPeople = 3;
        System.out.println(" The constant variable numPeople is " + numPeople);

        final int count = 42;
        System.out.println(" The constant variable count is " + count);

        /*trying to modify a constant
         *final int count = 56;
         *System.out.println (" The constant variable count is " + count);
         *
         * produced error: variable count is already defined in method
         */

    }
}

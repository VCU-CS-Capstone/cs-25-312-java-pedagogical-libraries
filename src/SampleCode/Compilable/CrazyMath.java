package SampleCode.Compilable;

import java.util.Arrays;

public class CrazyMath {
    public static void main(String[] args) {
        System.out.println("Evaluating a factorial recursively");
        int n = 5;
        System.out.println("Factorial of " + n + " is " + factorial(5));

        System.out.println();

        System.out.println("Making a list (array), and summing it twice");
        int[] santaCosts = new int[]{4, 7, 2, -1};
        System.out.println("Doubled sum of " + Arrays.toString(santaCosts) + " is " + doubleSum(santaCosts));
    }

    private static int factorial(int n) {
        // TODO: handle negatives
        if(n < 2) {
            return 1;
        }
        return n * factorial(n-1);
    }

    private static int doubleSum(int[] nums) {
        int twiceCost = 0;
        for(int item : nums) {
            twiceCost = twiceCost + item + item;
        }
        return twiceCost;
    }
}

package SampleCode.Compilable;

import java.util.Arrays;

public class WackyMath {
    public static void main(String[] args) {
        System.out.println("Evaluating a factorial iteratively");
        int n = 5;
        System.out.println("Factorial of " + n + " is " + factorial(n));

        System.out.println();

        System.out.println("Making a list (array), and getting confused");
        int[] santaCosts = new int[]{4, 7, 2, -1};
        int twiceCost = 0;
        for(int cost : santaCosts) {
            twiceCost = cost + cost;
        }
        System.out.println("Doubled sum of " + Arrays.toString(santaCosts) + " is NOT " + twiceCost);
    }

    private static int factorial(int n) {
        int out = 1;
        for(int i = 2; i <= n; i++) {
            out *= i;
        }
        return out;
    }
}
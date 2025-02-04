package SampleCode.Compilable;

public class WrongMath {
    /// Recursively computing a factorial
    private static int factorial(int n) {
        // Error: no base case, infinite recursion
        return n * factorial(n-1);
    }

    /// Using a classic for loop to count the number of even integers in the array
    public static int countEvens(int[] nums) {
        int evenCount = 0;
        for(int n : nums) {
            if(n % 2 == 0) {
                // Error: summing numbers instead of counting them
                evenCount += n;
            }
        }
        return evenCount;
    }
}

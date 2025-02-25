public class WackyMath {
    /// Computing a factorial without recursion
    private static int factorial(int n) {
        int out = 1;
        for(int i = 2; i <= n; i++) {
            out *= i;
        }
        return out;
    }

    /// Using a classic for loop to count the number of even integers in the array
    public static int countEvens(int[] nums) {
        int evenCount = 0;
        for(int n : nums) {
            if(n % 2 == 0) {
                evenCount += 1;
            }
        }
        return evenCount;
    }
}

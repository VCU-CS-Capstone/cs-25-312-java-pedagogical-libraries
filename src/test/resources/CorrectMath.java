public class CorrectMath {
    /// Recursively computing a factorial
    public static int factorial(int n) {
        if(n < 2) {
            return 1;
        }
        return n * factorial(n-1);
    }

    /// Using a for-each loop to count the number of even integers in the array
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

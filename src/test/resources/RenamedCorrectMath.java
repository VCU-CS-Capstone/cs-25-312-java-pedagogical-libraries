public class RenamedCorrectMath {
    /// This file should have the same exact structure as CorrectMath.java
    public static int factorial(int callMeIshmael) {
        if(callMeIshmael < 2) {
            return 1;
        }
        return callMeIshmael * factorial(callMeIshmael-1);
    }

    /// [Context for these variable names](https://xkcd.com/1960/)
    public static int countEvens(int[] someYearsAgoNeverMindHowLongPrecisely) {
        int havingLittleOrNoMoney = 0;
        for(int inMyPurseAndNothingParticular : someYearsAgoNeverMindHowLongPrecisely) {
            if(inMyPurseAndNothingParticular % 2 == 0) {
                havingLittleOrNoMoney += 1;
            }
        }
        return havingLittleOrNoMoney;
    }
}

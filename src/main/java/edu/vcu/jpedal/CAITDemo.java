package edu.vcu.jpedal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CAITDemo {
    public static void main(String[] args) {
        /*
         * Welcome to the CAIT demo!
         * Available files for testing:
         * [1] CorrectMath.java
         * [2] RenamedCorrectMath.java
         * etc.
         * Which would you like to search? Enter a number [1-2]:
         * > 2
         * The file is as follows:
         * (code)
         * Enter a pattern [1] or choose a predetermined pattern [2]?
         * > 2
         * Available patterns:
         * [1] for-each loop
         * [2] recursive function
         * Which would you like to match? Enter a number [1-2]:
         * > 1
         * Searching...
         * No matches found | Matches: (list them)
         */
        Scanner userIn = new Scanner(System.in);
        while(true) {
            List<String> tempList = new ArrayList<>();
            tempList.add("yo");
            tempList.add("hey");
            int a = promptList(userIn, tempList, "What is it?");
            System.out.println(a*2);
        }
    }
    
    private static int promptList(Scanner scanner, List<String> options, String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%s] %s%n", i+1, options.get(i));
        }
        int response = 0;
        while (response <= 0 || response > options.size()) {
            System.out.printf("Enter a number [1-%s]:%n", options.size());
            try {
                response = scanner.nextInt();
            } catch (InputMismatchException ignored) {
                scanner.nextLine();
            }
        }
        return response - 1;
    }
}

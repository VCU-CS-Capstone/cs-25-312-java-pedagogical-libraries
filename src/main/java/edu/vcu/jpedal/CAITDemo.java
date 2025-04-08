package edu.vcu.jpedal;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CAITDemo {
    String intendedOutput = """
    Welcome to the CAIT demo!
    Available files for testing:
    [1] CorrectMath.java
    [2] RenamedCorrectMath.java
    etc.
    Enter a number [1-2]:
    > 2
    The file is as follows:
    (code)
    Choose from predetermined patterns or enter a custom one?
    [1] Predetermined
    [2] Custom
    Enter a number [1-2]:
    > 2
    Available patterns:
    [1] for-each loop
    [2] recursive function
    Which would you like to match? Enter a number [1-2]:
    > 1
    Searching...
    No matches found | Matches: (list them)
    """;
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Welcome to the CAIT demo!");

        List<String> filesAvailable = getSourceSamples();
        if(filesAvailable.isEmpty()) {
            System.out.println("No sample code files found. Exiting...");
            return;
        }
        int selection = promptList(userIn, filesAvailable, "Sample code files available:");
        System.out.printf("TODO: selection %s%n", selection);
        // TODO: get corresponding file and parse
        selection = promptList(userIn, List.of("Predetermined", "Custom"), "Choose from predetermined patterns or enter a custom one?");
        System.out.printf("TODO: selection %s%n", selection);
        // TODO: pattern based on selection
        // TODO: print matches
        userIn.close();
    }

    private static List<String> getSourceSamples() {
        List<String> out = new ArrayList<String>();
        out.add("haha.java");
        return out;
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

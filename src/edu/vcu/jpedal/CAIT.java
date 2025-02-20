package edu.vcu.jpedal;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Capturing AST-Included Trees
 * TODO: write more description here
 */
public class CAIT {
    /**
     * Wrapper for parseSource that passes in a file's contents.
     * @param path path to the file to be read
     * @return the resulting JavaParser Node
     */
    public static Node parseFile(String path) {
        File infile = new File(path);
        StringBuilder sourceCode = new StringBuilder((int)infile.length());
        Scanner scanner;
        try {
            scanner = new Scanner(infile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(scanner.hasNextLine()) {
            sourceCode.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return parseSource(sourceCode.toString());
    }
    /**
     * Converts a Java file, in String form, into a JavaParser node.
     * @param sourceCode code to be parsed
     * @return the resulting root Node
     */
    public static Node parseSource(String sourceCode) {
        CompilationUnit parsedTree;
        try {
            // parses source code into an AST -kw
            parsedTree = StaticJavaParser.parse(sourceCode);
        }
        catch(Exception e) {
            System.out.println("Error when attempting to parse source: " + e.getMessage());
            return null;
        }
        // CompilationUnit is a subclass of Node so we don't actually need to reach into its root -dc
        return parsedTree;
    }
    /**
     *
     * @param pattern instructor-provided AST pattern to check for
     * @param studentCode entire student source code in one string
     * @return the first match found by calling findMatches, or null if there are none
     */
    public static Match findMatch(String pattern, String studentCode) {
        List<Match> matches = findMatches(pattern, studentCode);
        if(matches.isEmpty()) {
            return null;
        }
        return matches.getFirst();
    }

    /**
     * Returns all matches of a given pattern against a student source code file.
     *
     * @param pattern instructor-provided AST pattern to check for
     * @param studentCode entire student source code in one string
     * @return a List of all Matches found (may be empty)
     */
    public static List<Match> findMatches(String pattern, String studentCode) {
        // TODO: Use SubtreeMatching to get matches

        return new ArrayList<Match>();
    }
}

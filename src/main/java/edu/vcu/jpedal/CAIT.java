package edu.vcu.jpedal;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/// Capturing AST-Included Trees
///
/// Instructor-facing wrapper for internal CAIT methods.
/// Defers most of its functionality to TreeMatcher.
/// Also contains methods for converting from source code to AST Nodes.
public class CAIT {
    /**
     * Wrapper for parseSource that passes in a file's contents.
     * Converts the input String to a Path first.
     *
     * @param path String path to the file to be read
     * @return the resulting JavaParser Node
     */
    public static Node parseFile(String path) {
        return parseFile(Paths.get(path));
    }

    /**
     * Wrapper for parseSource that passes in a file's contents.
     *
     * @param path Path to the file to be read
     * @return the resulting JavaParser Node
     */
    public static Node parseFile(Path path) {
        String sourceCode = null;
        try {
            sourceCode = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parseSource(sourceCode);
    }

    /**
     * Converts a Java file, in String form, into a JavaParser node.
     *
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
     * Recursively compares two nodes, checking if they are equal.
     * TODO: delegate to TreeMatcher?
     *
     * @param node1 root of the first tree to be checked
     * @param node2 root of the second tree to be checked
     * @return whether the two trees are structurally equivalent
     */
    public static boolean nodesAreEqual(Node node1, Node node2) {
        // get the children of each node
        // there may be a more memory-efficient way to do this but this should work for now -ld
        List<Node> childrenNode1 = node1.getChildNodes();
        List<Node> childrenNode2 = node2.getChildNodes();

        // if the nodes do not have the same amount of children, they are not equal -ld
        if (childrenNode1.size() != childrenNode2.size())
            return false;

        // iterate through each child, return false if at any point the nodes are not equal -ld
        for (int i = 0; i < childrenNode1.size(); ++i) {
            if (!nodesAreEqual(childrenNode1.get(i), childrenNode2.get(i))) {
                // System.out.printf("Failed: '%s' and '%s' are not equal.\n", childrenNode1.get(i).toString(), childrenNode2.get(i).toString());
                return false;
            }
        }

        // return true if the nodes have equal amount of children -ld
        return true;
    }

    /**
     * Wrapper for findMatches that returns the first match found.
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
        // TODO: Use TreeMatcher to get matches
        return new ArrayList<Match>();
    }
}

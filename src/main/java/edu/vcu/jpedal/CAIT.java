package edu.vcu.jpedal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

/**
 * Instructor-facing wrapper for internal CAIT methods.
 * Used for parsing files and matching trees using JavaParser.
 * Handles source and pattern parsing and delegates comparison to TreeMatcher.
 */
public class CAIT {

    // Parses a file path (as String) into an AST node
    public static Node parseFile(String path) {
        return parseFile(Paths.get(path));
    }

    // Parses a Path object into an AST node
    public static Node parseFile(Path path) {
        String sourceCode;
        try {
            sourceCode = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parseSource(sourceCode);
    }

    // Converts raw source code into a JavaParser AST node
    public static Node parseSource(String sourceCode) {
        CompilationUnit parsedTree;
        try {
            parsedTree = StaticJavaParser.parse(sourceCode);
        } catch (Exception e) {
            System.out.println("Error when parsing source: " + e.getMessage());
            return null;
        }
        return parsedTree;
    }

    // Simple version that calls the detailed one below with a default class name
    public static Node parsePattern(String codePattern) {
        return parsePattern(codePattern, "CodeSnippet");
    }

    /**
     * Takes a code pattern and wraps it inside a fake class so JavaParser can understand it.
     * Useful when you're passing in just a snippet of code and not full classes.
     */
    public static Node parsePattern(String codePattern, String moduleName) {
        String wrappedSource = String.format(
                "public class %s { public static void main(String[] args) { %s } }",
                moduleName, codePattern
        );
        return parseSource(wrappedSource);
    }

    /**
     * Checks whether two trees look exactly the same.
     * Can be used to test similarity without needing a matcher.
     */
    public static boolean nodesAreEqual(Node node1, Node node2) {
        List<Node> children1 = node1.getChildNodes();
        List<Node> children2 = node2.getChildNodes();

        if (children1.size() != children2.size()) return false;

        for (int i = 0; i < children1.size(); i++) {
            if (!nodesAreEqual(children1.get(i), children2.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Returns the first match it finds (or null if no match)
    public static Match findMatch(String pattern, String studentCode) {
        List<Match> matches = findMatches(pattern, studentCode);
        return (matches != null && !matches.isEmpty()) ? matches.get(0) : null;
    }

    /**
     * Converts both pattern and student code to AST and returns all valid matches.
     * Delegates actual tree matching to TreeMatcher class.
     */
    public static List<Match> findMatches(String pattern, String studentCode) {
        // conversion into AST happens here
        Node patternAST=parsePattern(pattern);
        Node studentAST=parseSource(studentCode);

        if (patternAST == null || studentAST == null) {
            System.out.println("Error parsing pattern or student code.");
            return null;
        }

        return TreeMatcher.findMatches(patternAST, studentAST);
    }
}

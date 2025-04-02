package edu.vcu.jpedal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

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
        String sourceCode;
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
     * @see CAIT#parsePattern(String, String)
     */
    public static Node parsePattern(String codePattern) {
        return parsePattern(codePattern, "CodeSnippet");
    }

    /**
     * Takes the code snippet and transforms it into a compilable source file before passing it into parseSource.
     * @param codePattern any code pattern, not including its main function
     * @param moduleName name of the generated public class, defaults to CodeSnippet
     * @return the AST node generated from wrapping the snippet in a Java class
     */
    public static Node parsePattern(String codePattern, String moduleName) {
        CompilationUnit parsedTree;
        String wrappedSource = "public class %s { public static void main(String[] args) { %s } }".formatted(moduleName, codePattern);
        return parseSource(wrappedSource);
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
        List<Node> childrenNode1 = node1.getChildNodes();
        List<Node> childrenNode2 = node2.getChildNodes();

        // if the nodes do not have the same amount of children, they are not equal -ld
        if (childrenNode1.size() != childrenNode2.size())
            return false;

        // iterate through each child, return false if at any point the nodes are not equal -ld
        for (int i = 0; i < childrenNode1.size(); ++i) {
            if (!nodesAreEqual(childrenNode1.get(i), childrenNode2.get(i))) {
                return false;
            }
        }

        // no differences found
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
        // changed from matches.getFirst() to matches.get(0)
        // as List.getFirst() is not available pre 21 -ld
        return matches.get(0);
    }

    /**
     * Returns all matches of a given pattern against a student source code file.
     *
     * @param pattern instructor-provided AST pattern to check for
     * @param studentCode entire student source code in one string
     * @return a List of all Matches found (may be empty)
     */

     // TODO: Use TreeMatcher to get matches
    public static List<Match> findMatches(String pattern, String studentCode) {
        //empty list to store the matches
        List <Match> matches= new ArrayList<>();

        // conversion into AST happens here 
        Node patternAST=parseSource(pattern);
        Node studentAST=parseSource(studentCode);

        //checking to see if the parsing failed
        if(patternAST==null || studentAST==null){
            System.out.println("Error parsing the pattern or student code.");
            return matches;
        }
        //find matches between the two ASTs
        TreeMatcher matcher=new TreeMatcher();

        //add all the matches found to the list 
        matches.addAll(matcher.findMatches(patternAST, studentAST));
        return matches;
    }
}

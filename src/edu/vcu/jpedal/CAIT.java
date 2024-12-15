package edu.vcu.jpedal;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Capturing AST-Included Trees
 * TODO: write more description here
 */
public class CAIT {
    /**
     *
     * @param studentCode code to be parsed
     * @return root node of the resulting CompilationUnit
     */
    public static Node parseSource(String studentCode) {
        // TODO: cache nodes to avoid reparsing
        CompilationUnit cu = StaticJavaParser.parse(studentCode);
        Node studentRoot = cu.findRootNode();
        return studentRoot;
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

package edu.vcu.jpedal;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.Node;

/// Drives the AST matching algorithm.
/// TODO: More description
public class TreeMatcher {
    /**
     * Gets all the mappings of a pattern to a source node.
     * Analogous to the `matchTrees(S,I)` function outlined in Chapter 4.2 of Gusukuma 2020.
     * @param patternNode Node representing the pattern to search for
     * @param studentNode Node to search through
     * @return a List of all valid mappings
     */
    public static List<Match> findMatches(Node patternNode, Node studentNode) {
        // TODO: preprocessing

        List<Match> output = deepMatch(patternNode, studentNode);
        for(Node studentChild : studentNode.getChildNodes()) {
            output.addAll(findMatches(patternNode, studentChild));
        }
        return output;
    }

    /**
     * Check if two nodes match, ignoring their children.
     * @param instructorNode First node to match
     * @param studentNode Second node to match
     * @return a boolean representing whether the nodes are structurally identical
     */
    public static boolean shallowMatch(Node instructorNode, Node studentNode) {
        if(instructorNode.getClass() != studentNode.getClass()) {
            return false;
        }
        // TODO: check more attributes
        return true;
    }

    /**
     * Recursively check for all possible instances of a pattern in a given source.
     * Analogous to the `addAllMatches(S,I) function outlined in Chapter 4.2 of Gusukuma 2020.
     * @param patternNode pattern node to search for
     * @param studentNode source node to search through
     * @return a List of all possible matches
     */
    public static List<Match> deepMatch(Node patternNode, Node studentNode) {
        List<Match> output = new ArrayList<>();
        if (!shallowMatch(patternNode, studentNode)) {
            return output;
        }

        output.add(new Match(patternNode, studentNode));
        for(Node patternChild : patternNode.getChildNodes()) {
            List<Match> partialMatches = new ArrayList<>();
            for(Node studentChild : studentNode.getChildNodes()) {
                partialMatches.addAll(deepMatch(patternChild, studentChild));
            }
            output = mergeMatches(output, partialMatches);
        }

        return output;
    }

    /**
     * Merges the matches in two lists.
     * TODO: How precisely do we merge? Cancel out symbol table conflicts?
     * @param first List of Nodes to merge
     * @param second List of Nodes to merge
     * @return List of Nodes resulting from the merge
     */
    private static List<Match> mergeMatches(List<Match> first, List<Match> second) {
        List<Match> output = new ArrayList<>();
        // TODO: replace naive implementation
        output.addAll(first);
        output.addAll(second);
        return output;
    }
}
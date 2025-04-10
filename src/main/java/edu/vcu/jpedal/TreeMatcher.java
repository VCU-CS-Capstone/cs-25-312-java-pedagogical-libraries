package edu.vcu.jpedal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.javaparser.ast.Node;

/// Drives the AST matching algorithm.
/// TODO: More description
public class TreeMatcher {
    public static List<Match> findMatches(Node patternNode, Node studentNode) {
        // TODO: preprocessing

        List<Match> output = deepMatch(patternNode, studentNode);

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
     * @param patternNode pattern node to search for
     * @param studentNode source node to search through
     * @return a List of all possible matches
     */
    public static List<Match> deepMatch(Node patternNode, Node studentNode) {
        List<Match> output = new ArrayList<>();
        if (!shallowMatch(patternNode, studentNode)) {
            return output;
        }

        List<Node> patternChildren = patternNode.getChildNodes();
        List<Node> studentChildren = studentNode.getChildNodes();

        if (patternChildren.isEmpty() && studentChildren.isEmpty()) {
            // leaf nodes
            // TODO: what is SymbolTable actually doing here? what should we put in it?
            output.add(new Match(patternNode, studentNode, new SymbolTable()));
            return output;
        }

        if (patternChildren.size() > studentChildren.size()) {
            // not enough children - no match possible
            return output;
        }

        for (int studentInd = 0; studentInd < studentChildren.size(); studentInd++) {
            if (!shallowMatch(patternChildren.getFirst(), studentChildren.get(studentInd))) {
                continue;
            }
            // TODO: figure out iterating children
        }

        return output;
    }
}
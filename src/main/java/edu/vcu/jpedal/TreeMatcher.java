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
     * Recursively check for all possible ways to match two nodes.
     * @param patternNode first node to match
     * @param studentNode second node to match
     * @return a List of all possible matches
     */
    public static List<Match> deepMatch(Node patternNode, Node studentNode) {
        List<Match> output = new ArrayList<>();
        if (patternNode.getClass().equals(studentNode.getClass())) {
            SymbolTable symbolTable=new SymbolTable();
            // check if the nodes have the same properties
            if (prop(patternNode, studentNode)) {
                output.add(new Match(patternNode,studentNode,symbolTable));
            }
            List<Node> patternChild=patternNode.getChildNodes();
            List<Node> studentChild=studentNode.getChildNodes();

            // make sure both nodes have the same num of children
            if (patternChild.size()==studentChild.size()) {
                for (int x= 0;x < patternChild.size();x++) {
                    output.addAll(findMatches(patternChild.get(x),studentChild.get(x)));
                }
            }
        }
        return output;
    }

    // makes sure that the pattern node and the student node have the same values
    private static boolean prop(Node patternNode, Node studentNode) {
        return Objects.equals(patternNode.toString(),studentNode.toString());
    }

}
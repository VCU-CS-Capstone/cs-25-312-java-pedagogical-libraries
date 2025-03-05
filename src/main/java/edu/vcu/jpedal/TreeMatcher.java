package edu.vcu.jpedal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.javaparser.ast.Node;

/// Drives the AST matching algorithm.
/// TODO: More description
public class TreeMatcher {
    public List<Match> findMatches(Node patternNode, Node studentNode) {
        List<Match> output = new ArrayList<>();
        // check if node types are the same
        if (patternNode.getClass().equals(studentNode.getClass())) {
            SymbolTable symbolTable=new SymbolTable();
            // check if the nodes have the same properties
            if (prop(patternNode, studentNode)) {
                //match object 
                output.add(new Match(patternNode,studentNode,symbolTable));
            }
            //get child nodes 
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
    private boolean prop(Node patternNode, Node studentNode) {
        return Objects.equals(patternNode.toString(),studentNode.toString());
    }

    /**
     * Check if two nodes match, ignoring their children.
     * @param nodeA First node to match
     * @param nodeB Second node to match
     * @return a boolean representing whether the nodes are structurally identical
     */
    public boolean shallowMatch(Node nodeA, Node nodeB) {
        return false;
    }
}
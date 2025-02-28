package edu.vcu.jpedal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.javaparser.ast.Node;

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
}
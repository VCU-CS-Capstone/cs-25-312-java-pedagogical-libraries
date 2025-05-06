package edu.vcu.jpedal;

import com.github.javaparser.ast.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds a mapping of pattern nodes to student nodes.
 */
public class Match {
    private Map<Node, Node> mappings;
    private SymbolTable symbolTable;

    /**
     * Constructs a Match object
     * @param patternNode Initial pattern node
     * @param studentNode Initial student node
     */
    public Match(Node patternNode, Node studentNode) {
        mappings = new HashMap<>();
        addMapping(patternNode, studentNode);
    }

    public void addMapping(Node patternNode, Node studentNode) {
        mappings.put(patternNode, studentNode);
        // TODO: handle symbol table
    }

    public boolean isCompatibleWith(Match other) {
        // TODO: implement
        return false;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}

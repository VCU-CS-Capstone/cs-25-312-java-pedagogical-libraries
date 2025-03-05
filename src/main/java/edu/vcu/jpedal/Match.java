package edu.vcu.jpedal;

import com.github.javaparser.ast.Node;

/// Represents one possible mapping of the pattern node to the source node.
public class Match {
    private Node patternNode;
    private Node studentNode;
    private SymbolTable symbolTable;

    /**
     * Constructs a Match object
     * @param patternNode
     * @param studentNode
     * @param symbolTable
     */
    public Match(Node patternNode, Node studentNode, SymbolTable symbolTable) {
        this.patternNode = patternNode;
        this.studentNode = studentNode;
        this.symbolTable = symbolTable;
    }

    /**
     * Returns the symbol table
     * @return the symbol table
     */
    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    /**
     * Sets the symbol table
     * @param symbolTable
     */
    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
}

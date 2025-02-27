package edu.vcu.jpedal;

import java.util.List;

import com.github.javaparser.ast.Node;

public class Match {
    private Node patternNode;
    private Node studentNode;
    private List<Node> subtree;
    private SymbolTable symbolTable;

    /**
     * Constructs a Match object
     * @param patternNode
     * @param studentNode
     * @param subtree
     * @param symbolTable
     */
    public Match(Node patternNode, Node studentNode, List<Node> subtree, SymbolTable symbolTable) {
        this.patternNode = patternNode;
        this.studentNode = studentNode;
        this.subtree = subtree;
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

    /**
     * Logs the subtree
     */
    public void logSubtree() {
        // TODO: add subtree logging
    }
}

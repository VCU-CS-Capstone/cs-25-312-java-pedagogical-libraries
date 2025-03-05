package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

/// Holds all possible mappings of pattern nodes to source nodes.
public class SymbolTable {
    // TODO: allow Instructor -> Student mappings
    private Map<String, Symbol> symbolTable;
    private boolean conflict;

    /**
     * Constructs a new symbol table
     */
    public SymbolTable() {
        this.symbolTable = new HashMap<String, Symbol>();
        this.conflict = false;
    }

    /**
     * Gets the conflict status
     * @return true if the table has a conflict
     */
    public boolean hasConflict() {
        return conflict;
    }

    /**
     * Adds the symbol to the table with the key
     * @param key the key for which the symbol is to be added
     * @param value the symbol to be added
     */
    public void addSymbol(String key, Symbol value) {
        symbolTable.put(key, value);
    }

    /**
     * Gets the data type of the symbol
     * @param key the key of the symbol
     * @return the data type of the corresponding symbol
     */
    public Type getSymbolDataType(String key) {
       /** Symbol __var__=symbolTable.get(key);
         return __var__!=null ? __var__.getDataType() : null; 
        suggestion just in case the symbol isn't in the table */
        return symbolTable.get(key).getDataType();
    }

    /**
     * Gets the name of the symbol
     * @param key the key of the symbol
     * @return the name of the corresponding symbol
     */
    public SimpleName getSymbolName(String key) {
         /** Symbol __var__=symbolTable.get(key);
         return __var__!=null ? __var__.getName() : null; 
        suggestion just in case the symbol isn't in the table */
        return symbolTable.get(key).getName();
    }

    /**
     * Gets the expression of the symbol
     * @param key the key of the symbol
     * @return the expression of the corresponding symbol
     */
    public Expression getSymbolValue(String key) {
        /** Symbol __var__=symbolTable.get(key);
         return __var__!=null ? __var__.Value() : null; */
        return symbolTable.get(key).getValue();
    }
}

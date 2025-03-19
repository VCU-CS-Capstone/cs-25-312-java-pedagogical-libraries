package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

/*
 * - Added `merge(SymbolTable otherTable)`: Allows merging of two symbol tables while tracking conflicts.
 * - Added `getAllSymbols()`: Provides a copy of all stored symbols for better tracking and debugging.
 * - Added `getSymbol(String key)`: Retrieves a symbol from the table, resolving errors in ScopedSymbolTable.
 * - Ensured conflict detection: If a key already exists during merging, the conflict flag is set to `true`.
 * - Preserved all existing functionality while improving robustness.
 *
 * These updates support better symbol tracking and integration with ScopedSymbolTable and InstructorSymbolTable.
 */

/**
 * Holds all possible mappings of pattern nodes to source nodes.
 */
public class SymbolTable {
    private final Map<String, Symbol> symbolTable;
    private boolean conflict;

    /**
     * Constructs a new symbol table
     */
    public SymbolTable() {
        this.symbolTable = new HashMap<>();
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
     * Retrieves a symbol by key from the symbol table.
     * @param key The key of the symbol.
     * @return The corresponding Symbol, or null if not found.
     */
    public Symbol getSymbol(String key) {
        return symbolTable.getOrDefault(key, null);
    }

    /**
     * Gets the data type of the symbol
     * @param key the key of the symbol
     * @return the data type of the corresponding symbol
     */
    public Type getSymbolDataType(String key) {
        Symbol symbol = symbolTable.get(key);
        return (symbol != null) ? symbol.getDataType() : null;
    }

    /**
     * Gets the name of the symbol
     * @param key the key of the symbol
     * @return the name of the corresponding symbol
     */
    public SimpleName getSymbolName(String key) {
        Symbol symbol = symbolTable.get(key);
        return (symbol != null) ? symbol.getName() : null;
    }

    /**
     * Gets the expression of the symbol
     * @param key the key of the symbol
     * @return the expression of the corresponding symbol
     */
    public Expression getSymbolValue(String key) {
        Symbol symbol = symbolTable.get(key);
        return (symbol != null) ? symbol.getValue() : null;
    }

    /**
     * Merges another symbol table into this one.
     * If there are conflicts, it marks the conflict flag but does not overwrite existing values.
     * @param otherTable The other SymbolTable to merge.
     */
    public void merge(SymbolTable otherTable) {
        for (Map.Entry<String, Symbol> entry : otherTable.symbolTable.entrySet()) {
            if (symbolTable.containsKey(entry.getKey())) {
                conflict = true;  // Mark conflict if the same key exists
            } else {
                symbolTable.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Gets all symbols stored in this table.
     * @return A copy of the entire symbol table.
     */
    public Map<String, Symbol> getAllSymbols() {
        return new HashMap<>(symbolTable);
    }
}

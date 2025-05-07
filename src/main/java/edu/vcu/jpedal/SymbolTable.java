package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

/**
 * SymbolTable stores all variable-related data using a simple key-value structure.
 * Each key is a variable name (as a String), and the value is a Symbol object
 * which includes name, type, and expression.
 *
 * This class helps during AST matching by keeping track of what variables were declared,
 * their types, and values.
 */
public class SymbolTable {

    // Main storage: variable name → Symbol
    private final Map<String, Symbol> symbolTable;

    // Tells us if a conflict happened during merging (e.g. same name, different value)
    private boolean conflict;

    /**
     * Constructor that starts with an empty table.
     */
    public SymbolTable() {
        this.symbolTable = new HashMap<>();
        this.conflict = false;
    }

    /**
     * Adds a new variable to the table.
     *
     * @param key   the name of the symbol (usually a variable name)
     * @param value the Symbol object with details about the variable
     */
    public void addSymbol(String key, Symbol value) {
        symbolTable.put(key, value);
    }

    /**
     * Checks whether a conflict occurred during merging.
     *
     * @return true if a conflict was detected, false otherwise
     */
    public boolean hasConflict() {
        return conflict;
    }

    /**
     * Retrieves a full Symbol object by key.
     *
     * @param key the variable name to look up
     * @return the Symbol object, or null if not found
     */
    public Symbol getSymbol(String key) {
        return symbolTable.getOrDefault(key, null);
    }

    /**
     * Gets just the name part of the symbol (used in matching).
     *
     * @param key the variable name
     * @return the name part of the symbol, or null if not found
     */
    public SimpleName getSymbolName(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getName() : null;
    }

    /**
     * Gets the data type part of a stored symbol (e.g., int, String).
     *
     * @param key the variable name
     * @return the data type (Type), or null if not found
     */
    public Type getSymbolDataType(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getDataType() : null;
    }

    /**
     * Gets the expression (like a literal or calculation) from the symbol.
     *
     * @param key the variable name
     * @return the expression value of the symbol, or null if not found
     */
    public Expression getSymbolValue(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getValue() : null;
    }

    /**
     * Merges another SymbolTable into this one.
     * If there's a name conflict and the Symbols are different, marks conflict.
     *
     * @param otherTable another SymbolTable to merge into this one
     */
    public void merge(SymbolTable otherTable) {
        for (Map.Entry<String, Symbol> entry : otherTable.symbolTable.entrySet()) {
            String key = entry.getKey();
            Symbol newSymbol = entry.getValue();

            if (symbolTable.containsKey(key)) {
                Symbol existingSymbol = symbolTable.get(key);
                if (!existingSymbol.equals(newSymbol)) {
                    // Same name but different values = conflict
                    conflict = true;
                }
            } else {
                symbolTable.put(key, newSymbol);
            }
        }
    }

    /**
     * Returns all the symbols currently stored in the table.
     *
     * @return a copy of the internal symbol map
     */
    public Map<String, Symbol> getAllSymbols() {
        return new HashMap<>(symbolTable); // return copy for safety
    }
}

package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

/**
 * SymbolTable is where we store all symbols like variable names,
 * along with their data type and expression value.
 *
 * This is used during AST matching to compare instructor vs student code.
 */
public class SymbolTable {

    // Stores all the symbols, each linked to a name (string key)
    private final Map<String, Symbol> symbolTable;

    // Tells us if there was a conflict when merging two tables
    private boolean conflict;

    // Constructor to start with an empty table
    public SymbolTable() {
        this.symbolTable = new HashMap<>();
        this.conflict = false;
    }

    // Adds a new symbol into the table
    public void addSymbol(String key, Symbol value) {
        symbolTable.put(key, value);
    }

    // Checks whether any merge caused a conflict
    public boolean hasConflict() {
        return conflict;
    }

    // Gets a full Symbol object by its key (name)
    public Symbol getSymbol(String key) {
        return symbolTable.getOrDefault(key, null);
    }

    // Gets only the name of a symbol (used in matching)
    public SimpleName getSymbolName(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getName() : null;
    }

    // Gets only the data type (like int, String, etc.)
    public Type getSymbolDataType(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getDataType() : null;
    }

    // Gets the actual expression (value or code) stored
    public Expression getSymbolValue(String key) {
        Symbol symbol = getSymbol(key);
        return (symbol != null) ? symbol.getValue() : null;
    }

    /**
     * Merges another table into this one.
     * If there's a key conflict and the symbols are not the same, we set conflict = true.
     * If the symbol is already present and matches, we skip it.
     */
    public void merge(SymbolTable otherTable) {
        for (Map.Entry<String, Symbol> entry : otherTable.symbolTable.entrySet()) {
            String key = entry.getKey();
            Symbol newSymbol = entry.getValue();

            if (symbolTable.containsKey(key)) {
                Symbol existingSymbol = symbolTable.get(key);
                if (!existingSymbol.equals(newSymbol)) {
                    conflict = true; // same name, but different symbol → conflict
                }
                // If same symbol, no need to add again
            } else {
                symbolTable.put(key, newSymbol); // safe to add new symbol
            }
        }
    }

    // Returns all the symbols stored so far
    public Map<String, Symbol> getAllSymbols() {
        return new HashMap<>(symbolTable); // copy for safety
    }
}

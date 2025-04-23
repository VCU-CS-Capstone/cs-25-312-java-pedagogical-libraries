package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

/**
 * ScopedSymbolTable is like a SymbolTable that supports nested areas (scopes).
 * For example, variables inside a method should only be accessible inside that method.
 * This class helps organize that logic using named scopes.
 */
public class ScopedSymbolTable extends SymbolTable {

    // Stores a map of scope name (like function) to its symbol table
    private final Map<String, SymbolTable> scopes;

    // This lets us go up one level to the parent (outer) scope if needed
    private final ScopedSymbolTable parentScope;

    // Root-level scope constructor (no parent)
    public ScopedSymbolTable() {
        super();
        scopes = new HashMap<>();
        this.parentScope = null;
    }

    // Constructor used when there’s a parent scope (nested block)
    public ScopedSymbolTable(ScopedSymbolTable parentScope) {
        super();
        scopes = new HashMap<>();
        this.parentScope = parentScope;
    }

    /**
     * Creates a new scope with a given name.
     * For example, a method scope or a class scope.
     */
    public void addScope(String scopeName) {
        scopes.put(scopeName, new SymbolTable());
    }

    /**
     * Get the symbol table for a specific scope.
     * Returns null if that scope doesn't exist.
     */
    public SymbolTable getScope(String scopeName) {
        return scopes.get(scopeName);
    }

    /**
     * Checks whether a scope already exists by name.
     */
    public boolean scopeExists(String scopeName) {
        return scopes.containsKey(scopeName);
    }

    /**
     * This merges another symbol table into the given scope.
     * If the scope exists, it merges the entries into it.
     * If the scope doesn't exist, it just adds the new one.
     */
    public void mergeScope(String scopeName, SymbolTable otherScope) {
        if (scopes.containsKey(scopeName)) {
            scopes.get(scopeName).merge(otherScope);
        } else {
            scopes.put(scopeName, otherScope);
        }
    }

    /**
     * Look for a symbol in a specific scope. If it's not there, fall back to the current/global scope,
     * and if still not found, ask the parent (outer) scope.
     */
    public Symbol lookup(String key, String scopeName) {
        // 1. Check the requested scope first
        if (scopes.containsKey(scopeName)) {
            Symbol symbol = scopes.get(scopeName).getAllSymbols().get(key);
            if (symbol != null) {
                return symbol;
            }
        }

        // 2. If not found, check this level's main table
        Symbol symbol = getAllSymbols().get(key);
        if (symbol != null) {
            return symbol;
        }

        // 3. Finally, try looking in the parent scope (if any)
        if (parentScope != null) {
            return parentScope.lookup(key, scopeName);
        }

        // 4. Symbol not found anywhere
        return null;
    }
}

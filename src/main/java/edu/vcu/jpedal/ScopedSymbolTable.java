package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

/**
 * ScopedSymbolTable is an extension of SymbolTable that adds the idea of named "scopes",
 * which are useful when working with nested blocks of code like methods or loops.
 *
 * For example, if a variable is defined inside a method, it should only be accessible
 * inside that method. This class helps manage that behavior using scope names.
 */
public class ScopedSymbolTable extends SymbolTable {

    // Maps scope names (like function or class names) to their own symbol tables
    private final Map<String, SymbolTable> scopes;

    // Allows lookup to go to an outer scope if the symbol isn't found in the current one
    private final ScopedSymbolTable parentScope;

    /**
     * Constructor for the root scope (i.e., no parent scope).
     */
    public ScopedSymbolTable() {
        super();
        scopes = new HashMap<>();
        this.parentScope = null;
    }

    /**
     * Constructor for a nested scope. Pass in the parent scope it belongs to.
     *
     * @param parentScope the outer or parent scope this one is nested under
     */
    public ScopedSymbolTable(ScopedSymbolTable parentScope) {
        super();
        scopes = new HashMap<>();
        this.parentScope = parentScope;
    }

    /**
     * Adds a new named scope. This is like saying:
     * "From this point forward, keep symbols in this new group."
     *
     * @param scopeName the label for the new scope (e.g., function name)
     */
    public void addScope(String scopeName) {
        scopes.put(scopeName, new SymbolTable());
    }

    /**
     * Gets the symbol table tied to a specific scope.
     *
     * @param scopeName the scope to retrieve
     * @return the symbol table for that scope, or null if not found
     */
    public SymbolTable getScope(String scopeName) {
        return scopes.get(scopeName);
    }

    /**
     * Checks whether a scope with the given name already exists.
     *
     * @param scopeName name of the scope
     * @return true if scope is present, false if not
     */
    public boolean scopeExists(String scopeName) {
        return scopes.containsKey(scopeName);
    }

    /**
     * Merges symbols from another symbol table into this one.
     * If the scope exists, it combines the new symbols with existing ones.
     * If the scope doesn't exist, it creates a new one with the incoming symbols.
     *
     * @param scopeName name of the scope to merge into
     * @param otherScope the other symbol table to bring in
     */
    public void mergeScope(String scopeName, SymbolTable otherScope) {
        if (scopes.containsKey(scopeName)) {
            scopes.get(scopeName).merge(otherScope);
        } else {
            scopes.put(scopeName, otherScope);
        }
    }

    /**
     * Attempts to find a symbol by name in the specified scope.
     * If it’s not found in the scope, it looks in the local/global level.
     * If still not found, it checks the parent scope (if there is one).
     *
     * @param key the variable name or identifier
     * @param scopeName the name of the scope to check first
     * @return the matching Symbol, or null if it’s not found anywhere
     */
    public Symbol lookup(String key, String scopeName) {
        // Step 1: Check the specific named scope
        if (scopes.containsKey(scopeName)) {
            Symbol symbol = scopes.get(scopeName).getAllSymbols().get(key);
            if (symbol != null) {
                return symbol;
            }
        }

        // Step 2: If not found, check this level’s own symbol table
        Symbol symbol = getAllSymbols().get(key);
        if (symbol != null) {
            return symbol;
        }

        // Step 3: Check parent scope recursively (if it exists)
        if (parentScope != null) {
            return parentScope.lookup(key, scopeName);
        }

        // Step 4: Not found anywhere
        return null;
    }
}

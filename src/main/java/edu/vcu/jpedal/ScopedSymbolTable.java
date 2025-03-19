package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;
/*
 * - Added `mergeScope(String scopeName, SymbolTable otherScope)`: Allows merging of symbols from another scope.
 * - Implemented `lookup(String key, String scopeName)`: Searches for a symbol in the given scope, with fallback to parent scope.
 * - Supports hierarchical scope resolution to integrate smoothly with AST matching.
 * - Ensures conflict detection when merging different scopes.
 *
 * These updates improve symbol resolution when handling AST transformations and comparisons.
 */
/**
 * ScopedSymbolTable extends SymbolTable to manage scoped symbol resolution.
 * - Supports nested scopes for better AST-based analysis.
 * - Provides functions to add, retrieve, and check scope existence.
 * - Implements hierarchical lookup and scope merging.
 */
public class ScopedSymbolTable extends SymbolTable {
    private final Map<String, SymbolTable> scopes;
    private final ScopedSymbolTable parentScope;

    public ScopedSymbolTable() {
        super();
        scopes = new HashMap<>();
        this.parentScope = null; // Root scope has no parent
    }

    public ScopedSymbolTable(ScopedSymbolTable parentScope) {
        super();
        scopes = new HashMap<>();
        this.parentScope = parentScope;
    }

    public void addScope(String scopeName) {
        scopes.put(scopeName, new SymbolTable());
    }

    public SymbolTable getScope(String scopeName) {
        return scopes.get(scopeName);
    }

    public boolean scopeExists(String scopeName) {
        return scopes.containsKey(scopeName);
    }

    /**
     * Merges symbols from another scope into this scope.
     * @param scopeName The name of the scope being merged.
     * @param otherScope The other scope to merge into this one.
     */
    public void mergeScope(String scopeName, SymbolTable otherScope) {
        if (scopes.containsKey(scopeName)) {
            scopes.get(scopeName).merge(otherScope);
        } else {
            scopes.put(scopeName, otherScope);
        }
    }

    /**
     * Look up a symbol within a specific scope, with fallback to parent scope.
     * @param key The symbol name.
     * @param scopeName The scope name to search in.
     * @return The Symbol if found, or null if not found in any scope.
     */
    public Symbol lookup(String key, String scopeName) {

        if (scopes.containsKey(scopeName)) {
            Symbol symbol = scopes.get(scopeName).getAllSymbols().get(key);
            if (symbol != null) {
                return symbol;
            }
        }


        Symbol symbol = getAllSymbols().get(key);
        if (symbol != null) {
            return symbol;
        }


        if (parentScope != null) {
            return parentScope.lookup(key, scopeName);
        }

        return null;
    }
}

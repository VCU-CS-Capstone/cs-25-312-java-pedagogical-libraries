package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

public class ScopedSymbolTable extends SymbolTable {
    private final Map<String, SymbolTable> scopes;

    public ScopedSymbolTable() {
        super();
        scopes = new HashMap<>();
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
}




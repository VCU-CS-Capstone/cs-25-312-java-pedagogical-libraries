package edu.vcu.jpedal;


import java.util.Map;

public class SymbolTable {
    // TODO: allow Instructor -> Student mappings
    private Map<String, Symbol> symbolTable;
    private boolean conflict = false;

    public boolean hasConflict() {
        return conflict;
    }
}

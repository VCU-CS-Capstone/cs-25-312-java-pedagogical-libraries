package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

/**
 * InstructorSymbolTable keeps track of symbol mappings between instructor and student AST nodes.
 * It allows lookup, merging, and conflict detection between mappings.
 */
public class InstructorSymbolTable {
    // This map links each instructor to their student-symbol mappings
    private final Map<String, Map<String, Symbol>> instructorToStudentMapping;

    // Keeps track of conflicts when merging tables (like duplicate keys with different symbols)
    private final Map<String, Boolean> conflictMap;

    // Constructor: initialize both maps
    public InstructorSymbolTable() {
        instructorToStudentMapping = new HashMap<>();
        conflictMap = new HashMap<>();
    }

    /**
     * Adds a new student symbol under an instructor.
     * If the instructor doesn't exist, creates the mapping.
     */
    public void addStudentSymbol(String instructorKey, String studentKey, Symbol studentSymbol) {
        instructorToStudentMapping
                .computeIfAbsent(instructorKey, k -> new HashMap<>())
                .put(studentKey, studentSymbol);
    }

    /**
     * Returns the student symbol if it exists, otherwise null.
     * Used for checking what a student submitted under an instructor's pattern.
     */
    public Symbol getStudentSymbol(String instructorKey, String studentKey) {
        if (!instructorToStudentMapping.containsKey(instructorKey)) return null;
        return instructorToStudentMapping.get(instructorKey).get(studentKey);
    }

    /**
     * Just a shortcut that behaves the same as getStudentSymbol().
     * Helps during testing or TreeMatcher usage.
     */
    public Symbol lookupStudentSymbol(String instructorKey, String studentKey) {
        return getStudentSymbol(instructorKey, studentKey);
    }

    /**
     * Checks if the instructor has at least one student mapped.
     */
    public boolean instructorHasStudents(String instructorKey) {
        return instructorToStudentMapping.containsKey(instructorKey);
    }

    /**
     * Combines another InstructorSymbolTable into this one.
     * If both tables have the same student key but different symbols, we flag it as a conflict.
     * Also skips merge if conflict occurs. Safe merge only.
     */
    public void mergeInstructorTable(InstructorSymbolTable otherTable) {
        for (String instructorKey : otherTable.instructorToStudentMapping.keySet()) {
            Map<String, Symbol> theirStudentMap = otherTable.instructorToStudentMapping.get(instructorKey);
            Map<String, Symbol> ourStudentMap = instructorToStudentMapping.computeIfAbsent(instructorKey, k -> new HashMap<>());

            for (Map.Entry<String, Symbol> entry : theirStudentMap.entrySet()) {
                String studentKey = entry.getKey();
                Symbol newSymbol = entry.getValue();

                if (!ourStudentMap.containsKey(studentKey)) {
                    // No conflict, safe to add
                    ourStudentMap.put(studentKey, newSymbol);
                } else {
                    Symbol existingSymbol = ourStudentMap.get(studentKey);
                    if (!existingSymbol.equals(newSymbol)) {
                        // Conflict: same key, different symbol
                        conflictMap.put(instructorKey + "_" + studentKey, true);
                    }
                    // If same symbol, do nothing — already mapped correctly
                }
            }
        }
    }

    /**
     * Returns true if a conflict was flagged during merging.
     */
    public boolean hasConflict(String instructorKey, String studentKey) {
        return conflictMap.getOrDefault(instructorKey + "_" + studentKey, false);
    }
}

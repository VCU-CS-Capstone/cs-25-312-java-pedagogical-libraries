package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

/*
 * - Added `mergeInstructorTable(InstructorSymbolTable otherTable)`: Allows merging instructor mappings.
 * - Implemented `getStudentSymbol(String instructorKey, String studentKey)`: Retrieves student symbols.
 * - Implemented `lookupStudentSymbol(String instructorKey, String studentKey)`: Alias for `getStudentSymbol` to match test cases.
 * - Supports hierarchical tracking for instructor-student relationships.
 * - Detects symbol conflicts when merging different instructor mappings.
 *
 * These updates ensure smoother symbol resolution in AST Matching.
 */

/**
 * InstructorSymbolTable manages mappings of instructors to student symbol tables.
 * - Stores and retrieves symbols for specific students under an instructor.
 * - Supports hierarchical symbol tracking for different levels.
 * - Merges instructor symbol tables while detecting conflicts.
 */
public class InstructorSymbolTable {
    private final Map<String, Map<String, Symbol>> instructorToStudentMapping;
    private final Map<String, Boolean> conflictMap;

    public InstructorSymbolTable() {
        instructorToStudentMapping = new HashMap<>();
        conflictMap = new HashMap<>();
    }

    /**
     * Adds a student symbol under a specific instructor.
     * @param instructorKey The instructor's identifier.
     * @param studentKey The student's identifier.
     * @param studentSymbol The symbol associated with the student.
     */
    public void addStudentSymbol(String instructorKey, String studentKey, Symbol studentSymbol) {
        instructorToStudentMapping
                .computeIfAbsent(instructorKey, k -> new HashMap<>())
                .put(studentKey, studentSymbol);
    }

    /**
     * Retrieves a student symbol given the instructor's and student's keys.
     * @param instructorKey The instructor's identifier.
     * @param studentKey The student's identifier.
     * @return The student's Symbol object, or null if not found.
     */
    public Symbol getStudentSymbol(String instructorKey, String studentKey) {
        return (instructorToStudentMapping.containsKey(instructorKey))
                ? instructorToStudentMapping.get(instructorKey).get(studentKey)
                : null;
    }

    /**
     * @param instructorKey The instructor's identifier.
     * @param studentKey The student's identifier.
     * @return The student's Symbol object, or null if not found.
     */
    public Symbol lookupStudentSymbol(String instructorKey, String studentKey) {
        return getStudentSymbol(instructorKey, studentKey);
    }

    /**
     * Checks if an instructor has associated students.
     * @param instructorKey The instructor's identifier.
     * @return True if the instructor has students, false otherwise.
     */
    public boolean instructorHasStudents(String instructorKey) {
        return instructorToStudentMapping.containsKey(instructorKey);
    }

    /**
     * Merges another InstructorSymbolTable into this one.
     * - Ensures that conflicts are detected if the same student is mapped to different symbols.
     * @param otherTable The InstructorSymbolTable to be merged.
     */
    public void mergeInstructorTable(InstructorSymbolTable otherTable) {
        for (String instructorKey : otherTable.instructorToStudentMapping.keySet()) {
            if (!instructorToStudentMapping.containsKey(instructorKey)) {
                instructorToStudentMapping.put(instructorKey, otherTable.instructorToStudentMapping.get(instructorKey));
            } else {
                for (String studentKey : otherTable.instructorToStudentMapping.get(instructorKey).keySet()) {
                    Symbol otherSymbol = otherTable.instructorToStudentMapping.get(instructorKey).get(studentKey);
                    if (!instructorToStudentMapping.get(instructorKey).containsKey(studentKey)) {
                        instructorToStudentMapping.get(instructorKey).put(studentKey, otherSymbol);
                    } else {
                        conflictMap.put(instructorKey + "_" + studentKey, true);
                    }
                }
            }
        }
    }

    /**
     * Checks if there is a conflict in an instructor-student mapping.
     * @param instructorKey The instructor's identifier.
     * @param studentKey The student's identifier.
     * @return True if a conflict exists, false otherwise.
     */
    public boolean hasConflict(String instructorKey, String studentKey) {
        return conflictMap.getOrDefault(instructorKey + "_" + studentKey, false);
    }
}

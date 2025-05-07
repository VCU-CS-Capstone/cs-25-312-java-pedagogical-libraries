package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

/**
 * InstructorSymbolTable manages mappings between instructor-defined identifiers
 * and the corresponding student-submitted symbols.
 *
 * <p>This class supports adding symbols, retrieving them,
 * merging symbol mappings from another table, and detecting conflicts
 * when different symbols are mapped to the same key.</p>
 */
public class InstructorSymbolTable {

    // Keeps instructor -> (studentKey -> Symbol) mappings
    private final Map<String, Map<String, Symbol>> instructorToStudentMapping;

    // Tracks conflicts: same student key mapped to different symbols
    private final Map<String, Boolean> conflictMap;

    /**
     * Constructs an empty InstructorSymbolTable.
     * Initializes the internal maps used for storage and conflict tracking.
     */
    public InstructorSymbolTable() {
        instructorToStudentMapping = new HashMap<>();
        conflictMap = new HashMap<>();
    }

    /**
     * Adds a student symbol under a specific instructor.
     * Creates a new map for the instructor if not already present.
     *
     * @param instructorKey the unique identifier for the instructor
     * @param studentKey    the identifier submitted by the student
     * @param studentSymbol the symbol object representing the student submission
     */
    public void addStudentSymbol(String instructorKey, String studentKey, Symbol studentSymbol) {
        instructorToStudentMapping
                .computeIfAbsent(instructorKey, k -> new HashMap<>())
                .put(studentKey, studentSymbol);
    }

    /**
     * Retrieves a student’s symbol for a specific instructor.
     *
     * @param instructorKey the instructor's identifier
     * @param studentKey    the student identifier
     * @return the associated Symbol or null if not found
     */
    public Symbol getStudentSymbol(String instructorKey, String studentKey) {
        if (!instructorToStudentMapping.containsKey(instructorKey)) return null;
        return instructorToStudentMapping.get(instructorKey).get(studentKey);
    }

    /**
     * Alias method for getStudentSymbol — helpful for clarity during AST matching.
     *
     * @param instructorKey the instructor’s key
     * @param studentKey    the student’s key
     * @return the matching symbol if it exists, else null
     */
    public Symbol lookupStudentSymbol(String instructorKey, String studentKey) {
        return getStudentSymbol(instructorKey, studentKey);
    }

    /**
     * Checks if an instructor has any mapped student symbols.
     *
     * @param instructorKey the instructor’s key
     * @return true if mappings exist, otherwise false
     */
    public boolean instructorHasStudents(String instructorKey) {
        return instructorToStudentMapping.containsKey(instructorKey);
    }

    /**
     * Merges another InstructorSymbolTable into the current one.
     * If both tables map the same student key to different symbols, a conflict is logged.
     *
     * @param otherTable another InstructorSymbolTable to merge
     */
    public void mergeInstructorTable(InstructorSymbolTable otherTable) {
        for (String instructorKey : otherTable.instructorToStudentMapping.keySet()) {
            Map<String, Symbol> theirStudentMap = otherTable.instructorToStudentMapping.get(instructorKey);
            Map<String, Symbol> ourStudentMap = instructorToStudentMapping
                    .computeIfAbsent(instructorKey, k -> new HashMap<>());

            for (Map.Entry<String, Symbol> entry : theirStudentMap.entrySet()) {
                String studentKey = entry.getKey();
                Symbol newSymbol = entry.getValue();

                if (!ourStudentMap.containsKey(studentKey)) {
                    // No conflict, safe to add
                    ourStudentMap.put(studentKey, newSymbol);
                } else {
                    Symbol existingSymbol = ourStudentMap.get(studentKey);
                    if (!existingSymbol.equals(newSymbol)) {
                        // Conflict detected: different symbol already present
                        conflictMap.put(instructorKey + "_" + studentKey, true);
                    }
                    // If they match, do nothing — no update needed
                }
            }
        }
    }

    /**
     * Checks if there was a conflict during merge for a specific instructor-student key.
     *
     * @param instructorKey the instructor’s key
     * @param studentKey    the student’s key
     * @return true if a conflict exists, false otherwise
     */
    public boolean hasConflict(String instructorKey, String studentKey) {
        return conflictMap.getOrDefault(instructorKey + "_" + studentKey, false);
    }
}

package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;

public class InstructorSymbolTable {
    private final Map<String, Map<String, Symbol>> instructorToStudentMapping;

    public InstructorSymbolTable() {
        instructorToStudentMapping = new HashMap<>();
    }

    public void addStudentSymbol(String instructorKey, String studentKey, Symbol studentSymbol) {
        instructorToStudentMapping
                .computeIfAbsent(instructorKey, k -> new HashMap<>())
                .put(studentKey, studentSymbol);
    }

    public Symbol getStudentSymbol(String instructorKey, String studentKey) {
        return (instructorToStudentMapping.containsKey(instructorKey))
                ? instructorToStudentMapping.get(instructorKey).get(studentKey)
                : null;
    }

    public boolean instructorHasStudents(String instructorKey) {
        return instructorToStudentMapping.containsKey(instructorKey);
    }
}

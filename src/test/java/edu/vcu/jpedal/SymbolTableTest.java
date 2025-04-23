package edu.vcu.jpedal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

public class SymbolTableTest {
    private SymbolTable symbolTable;
    private ScopedSymbolTable scopedSymbolTable;
    private InstructorSymbolTable instructorSymbolTable;

    @BeforeEach
    public void setUp() {
        symbolTable = new SymbolTable();
        scopedSymbolTable = new ScopedSymbolTable();
        instructorSymbolTable = new InstructorSymbolTable();
    }

    /** Test basic add and get functionality */
    @Test
    public void testAddAndRetrieveSymbol() {
        Symbol symbol = new Symbol(new SimpleName("x"), null, null);
        symbolTable.addSymbol("x", symbol);
        assertEquals(symbol, symbolTable.getSymbol("x"));
    }

    /** Test merging two symbol tables with no conflict */
    @Test
    public void testMergeSymbolTables() {
        SymbolTable otherTable = new SymbolTable();
        Symbol symbolA = new Symbol(new SimpleName("a"), null, null);
        Symbol symbolB = new Symbol(new SimpleName("b"), null, null);

        symbolTable.addSymbol("a", symbolA);
        otherTable.addSymbol("b", symbolB);

        symbolTable.merge(otherTable);

        assertTrue(symbolTable.getAllSymbols().containsKey("b"));
        assertFalse(symbolTable.hasConflict());
    }

    /** Test conflict is flagged correctly when merging */
    @Test
    public void testMergeConflictDetection() {
        SymbolTable otherTable = new SymbolTable();
        Symbol symbolA1 = new Symbol(new SimpleName("a"), null, null);
        Symbol symbolA2 = new Symbol(new SimpleName("a"), null, null);

        symbolTable.addSymbol("a", symbolA1);
        otherTable.addSymbol("a", symbolA2);

        symbolTable.merge(otherTable);

        assertTrue(symbolTable.hasConflict());
    }

    /** Test if symbol lookup works in local scope */
    @Test
    public void testScopedLookup() {
        scopedSymbolTable.addScope("global");
        Symbol symbol = new Symbol(new SimpleName("y"), null, null);
        scopedSymbolTable.getScope("global").addSymbol("y", symbol);

        assertEquals(symbol, scopedSymbolTable.lookup("y", "global"));
    }

    /** Test if lookup falls back to parent scope */
    @Test
    public void testScopedLookupWithParent() {
        ScopedSymbolTable parentScope = new ScopedSymbolTable();
        scopedSymbolTable = new ScopedSymbolTable(parentScope);

        Symbol parentSymbol = new Symbol(new SimpleName("z"), null, null);
        parentScope.addSymbol("z", parentSymbol);

        assertEquals(parentSymbol, scopedSymbolTable.lookup("z", "global"));
    }

    /** Test mapping and lookup in InstructorSymbolTable */
    @Test
    public void testInstructorToStudentMapping() {
        Symbol studentSymbol = new Symbol(new SimpleName("studentVar"), null, null);
        instructorSymbolTable.addStudentSymbol("ProfA", "Student1", studentSymbol);

        assertEquals(studentSymbol, instructorSymbolTable.lookupStudentSymbol("ProfA", "Student1"));
        assertTrue(instructorSymbolTable.instructorHasStudents("ProfA"));
    }

    /** Test null result when looking up a symbol that doesn't exist */
    @Test
    public void testLookupNonExistentSymbol() {
        assertNull(symbolTable.getSymbol("nonExistent"));
    }

    /** Test if lookup in an empty scope returns null */
    @Test
    public void testLookupInEmptyScope() {
        scopedSymbolTable.addScope("emptyScope");
        assertNull(scopedSymbolTable.lookup("unknown", "emptyScope"));
    }

    /** Test merging when multiple keys may conflict */
    @Test
    public void testMergeMultipleConflictingKeys() {
        SymbolTable otherTable = new SymbolTable();
        symbolTable.addSymbol("x", new Symbol(new SimpleName("x"), null, null));
        otherTable.addSymbol("x", new Symbol(new SimpleName("x"), null, null));
        otherTable.addSymbol("y", new Symbol(new SimpleName("y"), null, null));

        symbolTable.merge(otherTable);

        assertTrue(symbolTable.hasConflict());
        assertTrue(symbolTable.getAllSymbols().containsKey("y"));
    }

    /** Test merging instructor tables with conflict */
    @Test
    public void testInstructorConflictMerge() {
        InstructorSymbolTable tableA = new InstructorSymbolTable();
        InstructorSymbolTable tableB = new InstructorSymbolTable();

        Symbol sym1 = new Symbol(new SimpleName("id"), null, null);
        Symbol sym2 = new Symbol(new SimpleName("id"), null, null);

        tableA.addStudentSymbol("ProfX", "Student1", sym1);
        tableB.addStudentSymbol("ProfX", "Student1", sym2);

        tableA.mergeInstructorTable(tableB);

        assertTrue(tableA.hasConflict("ProfX", "Student1"));
    }
}

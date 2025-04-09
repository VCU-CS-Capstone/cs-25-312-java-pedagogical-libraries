package edu.vcu.jpedal;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;

class CAITNodeTest {

    @Test
    void testIdenticalDeclsAreEqual() {
        // Parse the same declaration twice
        Node node1 = CAIT.parsePattern("int x = 5;");
        Node node2 = CAIT.parsePattern("int x = 5;");
        assertTrue(CAIT.nodesAreEqual(node1, node2), "Identical declarations should be equal");
    }

    @Test
    void testVariableName() {
        Node node1 = CAIT.parsePattern("int x = 5;");
        Node node2 = CAIT.parsePattern("int y = 5;");
        assertFalse(CAIT.nodesAreEqual(node1, node2), "Variables with different names should not be considered equal");
    }
    @Test
    void testNodeTypeDifference() {
        String classCode = "class A {}";
        String interfaceCode = "interface A {}";
        Node node1 = CAIT.parseSource(classCode);
        Node node2 = CAIT.parseSource(interfaceCode);
    
        assertFalse(CAIT.nodesAreEqual(node1, node2),
                "Class and interface nodes should not be equal");
    }

    @Test
    void testEmptyNodesAreEqual() {
        Node node1 = CAIT.parseSource("");
        Node node2 = CAIT.parseSource("");
        
        
        assertTrue(CAIT.nodesAreEqual(node1, node2),
                "Two empty source inputs should output equal nodes");
    }


    @Test
    void testStatementOrder() {
        Node node1 = CAIT.parsePattern("int x = 1; int y = 2;");
        Node node2 = CAIT.parsePattern("int y = 2; int x = 1;");
        
        assertFalse(CAIT.nodesAreEqual(node1, node2),
                "Reordering statements should not produce equal nodes");
    }

    @Test
    void testNestedStructureEqual() {
        String code = "class A { void m() { int x = 1; } }";
        Node node1 = CAIT.parseSource(code);
        Node node2 = CAIT.parseSource(code);
        
        assertTrue(CAIT.nodesAreEqual(node1, node2),
                "Identical nested structures should be equal");
    }

    @Test
    void testMethodBody() {
        String code1 = "class A { void m() { int x = 1; } }";
        String code2 = "class A { void m() { int y = 2; } }";
        Node node1 = CAIT.parseSource(code1);
        Node node2 = CAIT.parseSource(code2);
        
        assertFalse(CAIT.nodesAreEqual(node1, node2),
                "Methods with different bodies should not be equal");
    }

    @Test
    void testNodeVariable() {
        Node node = CAIT.parsePattern("int z = 42;");
        
        List<VariableDeclarator> variables = node.findAll(VariableDeclarator.class);
        
        assertEquals(1, variables.size(), "Should find one variable declarator");
        
        assertEquals("z", variables.get(0).getNameAsString(), "Variable should be named 'z'");
    }

    @Test
    void testNonNull() {
        Node node = CAIT.parseSource("int x = 5;");
        
        assertNotNull(node, "Valid Java snippet should return a non-null AST node");
    }

    @Test
    void testSyntaxErrors() {
        Node node = CAIT.parseSource("public class {");
        assertNull(node, "Syntax errors should return null from parseSource");
    }
}

    


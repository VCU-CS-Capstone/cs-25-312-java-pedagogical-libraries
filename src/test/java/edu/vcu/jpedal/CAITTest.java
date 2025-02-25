package edu.vcu.jpedal;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CAITTest {

    @Test
    void testEmptyNodes() {
        Node emptyNode1 = new CompilationUnit();
        Node emptyNode2 = new CompilationUnit();
        assertTrue(CAIT.nodesAreEqual(emptyNode1, emptyNode2), "Empty nodes should be equal");
    }

    @Test
    void testIdenticalNodes() {
        String source = "public class Example { int x = 3; }";
        Node node1 = CAIT.parseSource(source);
        assertNotNull(node1, "Valid source code should not return null");
        Node node2 = CAIT.parseSource(source);
        assertNotNull(node2, "Valid source code should not return null");

        assertTrue(CAIT.nodesAreEqual(node1, node2), "Nodes built from the same source code should be equal");
    }

    @Test
    void testDifferentNodes() {
        String source1 = "public class Example { int x = 3; }";
        String source2 = "public class Example { }";
        Node node1 = CAIT.parseSource(source1);
        assertNotNull(node1, "Valid source code should not return null");
        Node node2 = CAIT.parseSource(source2);
        assertNotNull(node2, "Valid source code should not return null");

        assertFalse(CAIT.nodesAreEqual(node1, node2), "Nodes with differing structures should not be equal");
    }
}
package edu.vcu.jpedal;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
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

    @Test
    void testIdenticalFiles() {
        Path correctFile;
        try {
            correctFile = FileResourceHelper.getResource("CorrectMath.java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node node1 = CAIT.parseFile(correctFile);
        Node node2 = CAIT.parseFile(correctFile);

        assertTrue(CAIT.nodesAreEqual(node1, node2), "Nodes formed from the same file should be equal");
    }

    @Test
    void testDifferentFiles() {
        Path correctFile;
        Path wrongFile;
        try {
            correctFile = FileResourceHelper.getResource("CorrectMath.java");
            wrongFile = FileResourceHelper.getResource("WrongMath.java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node node1 = CAIT.parseFile(correctFile);
        Node node2 = CAIT.parseFile(wrongFile);

        assertFalse(CAIT.nodesAreEqual(node1, node2), "Nodes formed from structurally different files shouldn't be equal");
    }

    @Test
    void testRenamedFiles() {
        Path correctFile;
        Path renamedCorrectFile;
        try {
            correctFile = FileResourceHelper.getResource("CorrectMath.java");
            renamedCorrectFile = FileResourceHelper.getResource("RenamedCorrectMath.java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node node1 = CAIT.parseFile(correctFile);
        Node node2 = CAIT.parseFile(renamedCorrectFile);

        assertTrue(CAIT.nodesAreEqual(node1, node2), "Nodes formed from structurally identical files should be equal");
    }

    @Test
    void testClassWrapper() {
        String snippet = "int x = 5;";
        String source = "public class Example { public static void main(String[] args) { int y = 5; } }";
        Node node1 = CAIT.parsePattern(snippet);
        assertNotNull(node1, "Valid source code should not return null");
        Node node2 = CAIT.parseSource(source);
        assertNotNull(node2, "Valid source code should not return null");

        assertTrue(CAIT.nodesAreEqual(node1, node2), "Code snippet should be identical when compared to wrapper");
    }
}
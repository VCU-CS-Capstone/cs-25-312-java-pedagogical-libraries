package edu.vcu.jpedal;

import com.github.javaparser.ast.Node;

/**
 * Displays functionality for CAIT methods.
 * The hope is that instructors will run scripts that resemble this file exactly.
 * In that case, we can use this script as a usage example.
 */
public class SampleScript {
    public static void main(String[] args) {
        Node parsed = CAIT.parseSource(
                "public class SuperAwesome { public static void main(String[] args) { int x = 3; } }");
        assert parsed != null;
        System.out.println(parsed);

        Node fileParsed = CAIT.parseFile("src/SampleCode/Compilable/CorrectMath.java");
        assert fileParsed != null;
        fileParsed.walk(node -> System.out.println(node.getClass().getSimpleName() + ": " + node));
    }
}

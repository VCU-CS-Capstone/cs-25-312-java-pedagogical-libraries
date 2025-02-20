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

        final String PATH_TO_SAMPLES = "src/SampleCode/Compilable/";

        Node correctNode = CAIT.parseFile(PATH_TO_SAMPLES + "CorrectMath.java");
        assert correctNode != null;
        Node renamedCorrectNode = CAIT.parseFile(PATH_TO_SAMPLES + "RenamedCorrectMath.java");
        assert renamedCorrectNode != null;
        Node wackyNode = CAIT.parseFile(PATH_TO_SAMPLES + "WackyMath.java");
        assert wackyNode != null;
        // This should report EQUAL once nodesAreEqual is complete -dc
        System.out.println("correct and renamedCorrect are: " + (CAIT.nodesAreEqual(correctNode, renamedCorrectNode) ? "EQUAL" : "NOT EQUAL"));
        // This should report NOT EQUAL once nodesAreEqual is complete -dc
        System.out.println("correct and wacky are: " + (CAIT.nodesAreEqual(correctNode, wackyNode) ? "EQUAL" : "NOT EQUAL"));
        // This should report EQUAL once nodesAreEqual is complete - ld
        System.out.println("correct and correct are: " + (CAIT.nodesAreEqual(correctNode, correctNode) ? "EQUAL" : "NOT EQUAL"));
    }
}

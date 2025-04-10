package edu.vcu.jpedal;

import com.github.javaparser.ast.Node;

/// Displays functionality for CAIT methods.
/// The hope is that instructors will run scripts that resemble this file exactly.
/// In that case, we can use this script as a usage example.
public class SampleScript {
    public static void main(String[] args) {
        String pattern = "int _thingy_ = 3;";
        String code = "public class SuperAwesome { public static void main(String[] args) { int x = 3; } }";
        System.out.println(CAIT.findMatches("int _thingy_ = 3;", code));
    }
}

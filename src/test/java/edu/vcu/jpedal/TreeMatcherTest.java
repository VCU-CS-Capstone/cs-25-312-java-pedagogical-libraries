package edu.vcu.jpedal;

import com.github.javaparser.ast.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests for the tree matching algorithm.
 * Mostly pulled from <a href=https://github.com/pedal-edu/pedal/blob/master/tests/test_cait.py>test_cait.py</a>.
 */
public class TreeMatcherTest {
    /**
     * Tests that generic symbols can match.
     */
    @Test
    void testGenericMatch() {
        String instructorCode = """
                int _accu_ = 0;
                int[] _iList_ = __listInit__;
                for (int _item_: _iList_) {
                    _accu_ = _accu_ + _item_;
                }
                System.out.println(_accu_);
                """;
        String studentCode = """
                int sum = 0;
                int[] list = {1, 2, 3, 4};
                for (int item: list) {
                    sum = sum + item;
                }
                System.out.println(sum);
                """;

        Node instructorAST = CAIT.parsePattern(instructorCode);
        Node studentAST = CAIT.parsePattern(studentCode);


        List<Match> matches = TreeMatcher.findMatches(instructorAST, studentAST);
        assertFalse(matches.isEmpty(), "No matches found");

        Match firstMatch = matches.get(0);
        // TODO: make it possible to get the instances of a symbol out of a match
        // assertTrue(firstMatch.get("_accu_").length == 4, "Incorrect variable map");
    }

    @Test
    void testVarMatch() {

    }
}

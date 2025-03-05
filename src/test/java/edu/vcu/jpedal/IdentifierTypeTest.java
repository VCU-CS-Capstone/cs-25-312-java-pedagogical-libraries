package edu.vcu.jpedal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTypeTest {

    @Test
    void testNormalName() {
        assertEquals(IdentifierType.NONE, IdentifierType.identify("sum_of_parts"));
    }

    @Test
    void testSingleUnderscores() {
        assertEquals(IdentifierType.SYMBOL, IdentifierType.identify("_sum_of_parts_"));
    }

    @Test
    void testDoubleUnderscores() {
        assertEquals(IdentifierType.EXPRESSION, IdentifierType.identify("__sum_of_parts__"));
    }

    @Test
    void testTripleUnderscores() {
        assertEquals(IdentifierType.WILD_CARD, IdentifierType.identify("___"));
    }
}
package edu.vcu.jpedal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTypeTest {

    @Test
    void testNormalName() {
        assertEquals(IdentifierType.NONE, IdentifierType.identify("sum"));
    }

    @Test
    void testSingleUnderscores() {
        assertEquals(IdentifierType.SYMBOL, IdentifierType.identify("_sum_"));
    }

    @Test
    void testDoubleUnderscores() {
        assertEquals(IdentifierType.EXPRESSION, IdentifierType.identify("__sum__"));
    }

    @Test
    void testTripleUnderscores() {
        assertEquals(IdentifierType.WILD_CARD, IdentifierType.identify("___"));
    }
}
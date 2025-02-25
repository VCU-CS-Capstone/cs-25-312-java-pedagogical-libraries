package edu.vcu.jpedal;

public enum IdentifierType {
    VAR,
    EXP,
    WILD_CARD,
    FUNCTION,
    CLASS,
    NONE;
    public static IdentifierType identify(String lexeme) {
        // TODO: Complete this method
        return NONE;
    }
}

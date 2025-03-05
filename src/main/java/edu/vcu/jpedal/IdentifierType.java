package edu.vcu.jpedal;

/// Represents the possible patterns programmable by the instructor.
/// Wrap in single underscores for SYMBOL
/// Wrap in double underscores for EXPRESSION
/// Triple underscore for WILD_CARD
public enum IdentifierType {
    NONE,
    SYMBOL,
    EXPRESSION,
    WILD_CARD;
    public static IdentifierType identify(String lexeme) {
        // TODO: Complete this method
        return NONE;
    }
}

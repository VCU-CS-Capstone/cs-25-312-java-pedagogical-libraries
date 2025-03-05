package edu.vcu.jpedal;

import java.util.regex.Pattern;

/// Represents the possible patterns programmable by the instructor.
/// Wrap in single underscores for SYMBOL
/// Wrap in double underscores for EXPRESSION
/// Triple underscore for WILD_CARD
public enum IdentifierType {
    WILD_CARD("^___$"),
    EXPRESSION ("^__\\w+__$"),
    SYMBOL ("^_\\w+_$"),
    NONE (".*");

    private final Pattern regexPattern;
    IdentifierType(String regex) {
        regexPattern = Pattern.compile(regex);
    }

    /// Determines which IdentifierType is used by the given lexeme.
    ///
    /// @return the corresponding IdentifierType, or NONE if nothing special
    public static IdentifierType identify(String lexeme) {
        for(IdentifierType t: IdentifierType.values()) {
            if (t.regexPattern.matcher(lexeme).find()) {
                return t;
            }
        }
        return NONE;
    }
}

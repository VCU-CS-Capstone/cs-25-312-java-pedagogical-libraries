package edu.vcu.jpedal;

import java.util.HashMap;
import java.util.Map;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;
import java.util.Objects;

/**
 * Symbol class stores information about a variable or identifier.
 * Each symbol has a name, a type, and an optional value.
 */
public class Symbol {
    private SimpleName name;
    private Type dataType;
    private Expression value;

    /**
     * Constructor for Symbol.
     * Helps to create symbol objects quickly for testing and matching.
     *
     * @param name      the name of the symbol
     * @param dataType  the data type of the symbol
     * @param value     the value or expression of the symbol
     */
    public Symbol(SimpleName name, Type dataType, Expression value) {
        this.name = name;
        this.dataType = dataType;
        this.value = value;
    }

    // Getters and setters to access or modify symbol details
    public SimpleName getName() {
        return name;
    }

    public void setName(SimpleName name) {
        this.name = name;
    }

    public Type getDataType() {
        return dataType;
    }

    public void setDataType(Type dataType) {
        this.dataType = dataType;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    /**
     * This method is used to compare two Symbol objects.
     * If name, type, and value match, we consider them equal.
     *
     * @param obj the object to compare with
     * @return true if all fields match, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Symbol other = (Symbol) obj;

        return Objects.equals(name, other.name) &&
                Objects.equals(dataType, other.dataType) &&
                Objects.equals(value, other.value);
    }

    /**
     * This generates a unique number for each Symbol object.
     * It helps when symbols are stored in sets, maps, etc.
     *
     * @return hash code for the symbol
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, dataType, value);
    }
}

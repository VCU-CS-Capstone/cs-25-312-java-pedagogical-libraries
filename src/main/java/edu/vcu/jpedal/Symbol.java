package edu.vcu.jpedal;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

/// Represents a single Java symbol, such as an identifier or literal.
public class Symbol {
    private SimpleName name;
    private Type dataType;
    private Expression value;

  /*
  We added this constructor to make unit testing easier by allowing us to create Symbol objects
  with all necessary values in a single step. This avoids the need to manually set each property
  using setter methods, making the tests cleaner and more efficient
   */
    public Symbol(SimpleName name, Type dataType, Expression value) {
        this.name = name;
        this.dataType = dataType;
        this.value = value;
    }

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
}

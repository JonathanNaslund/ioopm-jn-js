package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    protected SymbolicExpression lhs = null;
    protected SymbolicExpression rhs = null;
    private String name;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs, String name) {
        super(0);
        this.lhs = lhs;
        this.rhs = rhs;
        this.name = name;
    }
    public String toString() {
     return String.valueOf(lhs) + " " + name + " " + String.valueOf(rhs);
    }
}

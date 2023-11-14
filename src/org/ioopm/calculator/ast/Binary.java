package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;
    private String name;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs, String name) {
        super(0);
        this.lhs = lhs;
        this.rhs = rhs;
        this.name = name;
    }
}

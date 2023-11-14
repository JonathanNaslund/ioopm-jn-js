package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    protected SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        super(1);
        this.expression = expression;
        this.name = name;
    }
    public String toString() {
        return this.getName() + " (" + this.expression.toString() + ")";
    }
}

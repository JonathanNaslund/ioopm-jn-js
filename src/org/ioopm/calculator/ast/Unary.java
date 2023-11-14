package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        super(1);
        this.expression = expression;
        this.name = name;
    }
}

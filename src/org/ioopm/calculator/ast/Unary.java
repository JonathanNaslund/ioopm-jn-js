package org.ioopm.calculator.ast;


public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        // super()
        this.expression = expression;
        this.name = name;
    }
    public String toString() {
     return this.getName() + " " + this.expression.toString();
    }
}

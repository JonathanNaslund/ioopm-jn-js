package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Unary extends SymbolicExpression {
    private SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        // super()
        this.expression = expression;
        this.name = name;
    }
}

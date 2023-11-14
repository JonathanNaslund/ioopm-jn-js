package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Exp extends Unary {

    public Exp(SymbolicExpression expression) {
        super(expression, "Exp");
    }

    @Override
    public String getName() {
        return "Exp";
    }
}

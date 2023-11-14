package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Cos extends Unary {
    
    public Cos(SymbolicExpression expression) {
        super(expression, "Cos");
    }

    @Override
    public String getName() {
        return "Cos";
    }
}

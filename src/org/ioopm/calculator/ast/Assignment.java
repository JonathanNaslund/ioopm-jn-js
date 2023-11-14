package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Assignment extends Binary {
    
    Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "=");
    }

    @Override
    public String getName() {
        return "=";
    }
}

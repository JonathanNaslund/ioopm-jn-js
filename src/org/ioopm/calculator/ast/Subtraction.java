package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Subtraction extends Binary {
    
    public    Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "-");
    }

    @Override
    public String getName() {
        return "-";
    }
}

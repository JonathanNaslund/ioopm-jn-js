package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "=", 1);
    }

    @Override
    public String getName() {
        return "=";
    }

    
}

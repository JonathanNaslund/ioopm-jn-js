package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "*", 2); 
    }

    @Override
    public String getName() {
        return "*";
    }
}

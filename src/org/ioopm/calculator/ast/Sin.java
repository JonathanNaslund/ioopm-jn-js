package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Sin extends Unary{
    
    public Sin(SymbolicExpression expression) {
        super(expression, "Sin");
    }

    @Override
    public String getName() {
        return "Sin";
    }
}

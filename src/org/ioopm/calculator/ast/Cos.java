package org.ioopm.calculator.ast;

public class Cos extends Unary {
    
    public Cos(SymbolicExpression expression) {
        super(expression, "Cos");
    }

    @Override
    public String getName() {
        return "Cos";
    }
}

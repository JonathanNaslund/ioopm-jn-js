package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression expression) {
        super(expression, "Neg");
    }

    @Override
    public String getName() {
        return "Neg";
    }
}

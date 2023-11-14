package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Constant extends Atom {
    private double value;
    public Constant(double value) {
        super(value);
        this.value=value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
}

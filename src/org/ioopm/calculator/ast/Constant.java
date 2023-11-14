package org.ioopm.calculator.ast;

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
    @Override
    public double getValue() {
     return value;
    }
}

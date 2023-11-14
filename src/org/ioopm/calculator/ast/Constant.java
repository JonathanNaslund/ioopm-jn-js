package org.ioopm.calculator.ast;

public class Constant extends Atom {
    
    public Constant(double value) {
        super(value);
    }

    @Override
    public boolean isConstant() {
        return true;
    }
    
    public String toString() {
     return String.valueOf(getValue());
    }

    public boolean equals(Object other) {
        if (other instanceof Constant) {
            return this.equals((Constant) other);
        } else {
            return false;
        }
    }
    
    public boolean equals(Constant other) {
        return getValue() == other.getValue();
    }
}

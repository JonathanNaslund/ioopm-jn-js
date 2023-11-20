package org.ioopm.calculator.ast;

public class Constant extends Atom {
    
    public Constant(double value) {
        super(value);
    }

    /**
     * Returns true to show caller that this object is a constant
     * @return true
     */
    @Override
    public boolean isConstant() {
        return true;
    }
    
    /**
     * @return the value of the constant
     */
    @Override
    public String toString() {
     return String.valueOf(getValue());
    }

    /**
     * Checks if this and an other objects are equal by calling on another equals
     * @param other the other object to compare to
     * @return true if they are equal, else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Constant) {
            return this.equals((Constant) other);
        } else {
            return false;
        }
    }
    
    /**
     * Checks if the values of this and another constant are the same
     * @param other the other constant to compare to
     * @return true if the two values are equal, else false
     */
    public boolean equals(Constant other) {
        return getValue() == other.getValue();
    }

    /**
     * Returns a new constant object the the same value
     * @param vars A hashtable that holds declared variables and their values
     * @return a new constant
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
     return new Constant(this.getValue());
    }

    /**
     * Returns false to show caller that this branch of the tree does not
     * have a undeclared variable.
     * @return false
     */
    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return false;
    }
}

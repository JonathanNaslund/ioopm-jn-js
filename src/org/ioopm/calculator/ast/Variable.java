package org.ioopm.calculator.ast;

public class Variable extends Atom {

    public Variable(String identifier) {
        super(identifier);
    }   

    public String toString() {
	    return this.getVariable();
    }

    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }
    
    public boolean equals(Variable other) {
        return getVariable().compareTo(other.getVariable()) == 0;
    }
    @Override
    public boolean isVariable() {
        return true;
    }
    @Override
    public SymbolicExpression eval() {
     return new Variable(this.getVariable());
    }
}

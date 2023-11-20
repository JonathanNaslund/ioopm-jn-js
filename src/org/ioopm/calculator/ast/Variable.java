package org.ioopm.calculator.ast;

public class Variable extends Atom {

    public Variable(String identifier) {
        super(identifier);
    }   

    /**
     * @return the value of the constant
     */
    public String toString() {
	    return this.getVariable();
    }

    /**
     * Checks if this and an other objects are equal by calling on another equals
     * @param other the other object to compare to
     * @return true if they are equal, else false
     */
    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }
    
    /**
     * Checks if the values of this and another variables are the same
     * @param other the other variable to compare to
     * @return true if the two values are equal, else false
     */
    public boolean equals(Variable other) {
        return getVariable().compareTo(other.getVariable()) == 0;
    }

    /**
     * Hashes the variable name to use as the code for the key. This overrides the original
     * to hash to variable name and not the variable object.
     * @return the hashcode after hashing the variable name
     */
    @Override
    public int hashCode() {
        return this.getVariable().hashCode();
    }
    
    /**
     * Returns true to show to caller that this object is a variable
     * @return true
     */
    @Override
    public boolean isVariable() {
        return true;
    }

    /**
     * Returns a the evaluated value if the variable has a declared value, else return
     * a new variable with the same variable name
     * @param vars A hashtable that holds declared variables and their values
     * @return the value if declared, else a new variable
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        if (vars.get(this) != null) {
            return vars.get(this).eval(vars);
        } else {
            return new Variable(this.getVariable());
        }
    } 

    /**
     * Returns if the variable is undeclared to not
     * @return true if the variable does not have a value, else false
     */
    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        if (vars.get(this) == null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double getValue() {
        throw new RuntimeException("getValue() on a variable");
    }
}


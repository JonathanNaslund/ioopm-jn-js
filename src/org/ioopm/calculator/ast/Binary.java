package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    protected SymbolicExpression lhs = null;
    protected SymbolicExpression rhs = null;
    private String name;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs, String name, int priority) {
        super(priority);
        this.lhs = lhs;
        this.rhs = rhs;
        this.name = name;
        changePriority();
    }

    /**
     * Changes priority to operations such as addition or subtraction to 3 if they are in need if a parentheses
     */
    private void changePriority() {
        if (this instanceof Multiplication || this instanceof Division) {
            if (lhs instanceof Addition || lhs instanceof Subtraction) {
                lhs.setPriority(3);
            } 
            if (rhs instanceof Addition || rhs instanceof Subtraction) {
                rhs.setPriority(3);
            }
        } else if (this instanceof Subtraction && rhs instanceof Addition) {
            rhs.setPriority(3);
        }
    }

    /**
     * Stringifies the operation
     * @return a string of the lhs and rhs with the operator inbetween
     */
    public String toString() {
	    if(getPriority() == 3) {
	    	return "(" + lhs.toString() + " " + this.getName() + " " + rhs.toString() + ")";
	    } else {
	    	return lhs.toString() + " " + this.getName() + " " + rhs.toString();
	    }
    }

    /**
     * Checks if this and an other object is equal by comparing lhs:s and rhs:s
     * @param other the other object to compare to
     * @return true if the two objects are equal, else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Binary) {
            Binary tmpBinary = (Binary) other;
            return (this.lhs.equals(tmpBinary.lhs) && this.rhs.equals(tmpBinary.rhs)); 
        } else {
            return false;
        }
    }

    /**
     * Checks if there are any undeclared in lhs and rhs
     * @param vars A hashtable that holds declared variables and their values
     * @return true if there are atleast one undeclared variable in either lhs or rhs or both, else false
     */
    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return (rhs.hasUndeclaredVariable(vars) || lhs.hasUndeclaredVariable(vars));
    }
}

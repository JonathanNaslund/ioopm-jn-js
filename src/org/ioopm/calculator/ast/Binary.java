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

    private void changePriority() {
        if (this instanceof Multiplication || this instanceof Division) {
            if ((lhs instanceof Addition || lhs instanceof Subtraction) && (rhs instanceof Addition || rhs instanceof Subtraction)) {
                lhs.setPriority(3);
                rhs.setPriority(3);
            } else if (lhs instanceof Addition || lhs instanceof Subtraction) {
                lhs.setPriority(3);
            } else if (rhs instanceof Addition || rhs instanceof Subtraction) {
                rhs.setPriority(3);
            }
        } else if (this instanceof Subtraction && rhs instanceof Addition) {
            rhs.setPriority(3);
        }
    }

    public String toString() {
	    if(getPriority() == 3) {
	    	return "(" + lhs.toString() + " " + this.getName() + " " + rhs.toString() + ")";
	    } else {
	    	return lhs.toString() + " " + this.getName() + " " + rhs.toString();
	    }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Binary) {
            Binary tmpBinary = (Binary) other;
            return (this.lhs.equals(tmpBinary.lhs) && this.rhs.equals(tmpBinary.rhs)); 
        } else {
            return false;
        }
    }

    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return (rhs.hasUndeclaredVariable(vars) || lhs.hasUndeclaredVariable(vars));
    }
}

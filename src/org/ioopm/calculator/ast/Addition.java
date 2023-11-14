package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "+", 1);
    }

    @Override
    public String getName() {
        return "+";
    }
    public String toString() {
	    if(getPriority() == 3) {
	    	return "(" + lhs.toString() + this.getName() + rhs.toString() + ")";
	    } else {
	    	return lhs.toString() + this.getName() + rhs.toString();
	    }
    }
}

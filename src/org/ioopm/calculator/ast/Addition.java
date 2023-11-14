package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "+");
    }

    @Override
    public String getName() {
        return "+";
    }
    public String toString() {
	    return lhs.toString() + this.getName() + rhs.toString();
    }
}

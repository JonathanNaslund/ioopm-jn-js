package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "-", 1);
    }

    @Override
    public String getName() {
        return "-";
    }

    public String toString() {
	    if(getPriority() == 3) {
	    	return "(" + lhs.toString() + this.getName() + rhs.toString() + ")";
	    } else {
	    	return lhs.toString() + this.getName() + rhs.toString();
	    }
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() -  rhs.getValue());
     }
     else if (lhs.isNamedConstant() && rhs.isNamedConstant()) {
        return new Subtraction(lhs, rhs.eval(vars)).eval(vars);
     }
     else if(lhs.isConstant()) {
        if (rhs.hasUndeclaredVariable(vars)) {
            return new Subtraction(lhs, rhs.eval(vars));
        } else {
            return new Subtraction(lhs, rhs.eval(vars)).eval(vars);
        }
     }
     else if(rhs.isConstant()) {
        if (lhs.hasUndeclaredVariable(vars)) {
            return new Subtraction(lhs.eval(vars), rhs);
        } else {
            return new Subtraction(lhs.eval(vars), rhs).eval(vars);
        }
    }
    else {
      return new Subtraction(lhs.eval(vars),  rhs.eval(vars));
     }
    }
}

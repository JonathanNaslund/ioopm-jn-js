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
    public SymbolicExpression eval(Environment vars) {
     SymbolicExpression evaluatedLhs = lhs.eval(vars);
     SymbolicExpression evaluatedRhs = rhs.eval(vars);
     if(evaluatedLhs.isConstant() && evaluatedRhs.isConstant()) {
      return new Constant(evaluatedLhs.getValue() - evaluatedRhs.getValue());
     }
     return new Subtraction(evaluatedLhs, evaluatedRhs);
    }
}

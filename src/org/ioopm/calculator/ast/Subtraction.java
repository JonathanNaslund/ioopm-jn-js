package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "-", 1);
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "-";
    }

    // public String toString() {
	//     if(getPriority() == 3) {
	//     	return "(" + lhs.toString() + this.getName() + rhs.toString() + ")";
	//     } else {
	//     	return lhs.toString() + this.getName() + rhs.toString();
	//     }
    // }

    /**
     * Evaluates the object. Subtracts lhs from rhs if there are not any undeclared variables in any
     * of the sides.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new subtraction
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression rhsTemp = rhs.eval(vars);
        SymbolicExpression lhsTemp = lhs.eval(vars);
     if(lhsTemp.isConstant() && rhsTemp.isConstant()) {
      return new Constant(lhsTemp.getValue() -  rhsTemp.getValue());
     }
     else if (lhsTemp.isNamedConstant() && rhsTemp.isNamedConstant()) {
        return new Subtraction(lhsTemp, rhsTemp).eval(vars);
     }
     else if(lhsTemp.isConstant()) {
        if (rhsTemp.hasUndeclaredVariable(vars)) {
            return new Subtraction(lhsTemp, rhsTemp);
        } else {
            return new Subtraction(lhsTemp, rhsTemp).eval(vars);
        }
     }
     else if(rhsTemp.isConstant()) {
        if (lhsTemp.hasUndeclaredVariable(vars)) {
            return new Subtraction(lhsTemp, rhsTemp);
        } else {
            return new Subtraction(lhsTemp, rhsTemp).eval(vars);
        }
    }
    else {
      return new Subtraction(lhsTemp, rhsTemp);
     }
    }
}

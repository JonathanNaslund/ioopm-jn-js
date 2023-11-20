package org.ioopm.calculator.ast;

public class Division extends Binary {
    
  public  Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "/", 2);
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "/";
    }

    
    /**
     * Evaluates the object. Divide lhs by rhs if there are not any undeclared variables in any
     * of the sides or if rhs does not equal 0.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new divison
     * @throws RuntieException if rhs is equal to 0.
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression rhsTemp = rhs.eval(vars);
        SymbolicExpression lhsTemp = lhs.eval(vars);
    if(rhsTemp.isConstant()) {
        if ((rhsTemp).getValue() == 0) {
            throw new DivideByZeroException("Division by 0");
        }
	}
     if(lhsTemp.isConstant() && rhsTemp.isConstant()) {
      return new Constant(lhsTemp.getValue() / rhsTemp.getValue());
     }
     else if (lhsTemp.isNamedConstant() && rhsTemp.isNamedConstant()) {
        return new Division(lhsTemp, rhsTemp.eval(vars)).eval(vars);
     }
     else if(lhsTemp.isConstant()) {
        if (rhsTemp.hasUndeclaredVariable(vars)) {
            return new Division(lhsTemp, rhsTemp.eval(vars));
        } else {
            return new Division(lhsTemp, rhsTemp.eval(vars)).eval(vars);
        }
     }
     else if(rhsTemp.isConstant()) {
        if (lhsTemp.hasUndeclaredVariable(vars)) {
            return new Division(lhsTemp.eval(vars), rhsTemp);
        } else {
            return new Division(lhsTemp.eval(vars), rhsTemp).eval(vars);
        }
    }
    else {
      return new Division(lhsTemp.eval(vars),  rhsTemp.eval(vars));
     }
    }
}

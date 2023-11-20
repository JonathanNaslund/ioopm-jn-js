package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "+", 1);
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "+";
    }
    
    /**
     * Evaluates the object. Adds lhs to rhs if there are not any undeclared variables in any
     * of the sides.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new addition
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        SymbolicExpression rhsTemp = rhs.eval(vars);
        SymbolicExpression lhsTemp = lhs.eval(vars);
     if(lhsTemp.isConstant() && rhsTemp.isConstant()) {
      return new Constant(lhsTemp.getValue() + rhsTemp.getValue());
     }
     else if (lhsTemp.isNamedConstant() && rhsTemp.isNamedConstant()) {
        return new Addition(lhsTemp, rhsTemp).eval(vars);
     }
     else if(lhs.isConstant()) {
        if (rhs.hasUndeclaredVariable(vars)) {
            return new Addition(lhsTemp, rhsTemp);
        } else {
            return new Addition(lhsTemp, rhsTemp).eval(vars);
        }
     }
     else if(rhs.isConstant()) {
        if (lhs.hasUndeclaredVariable(vars)) {
            return new Addition(lhsTemp, rhsTemp);
        } else {
            return new Addition(lhsTemp, rhsTemp).eval(vars);
        }
    }
    else {
      return new Addition(lhsTemp,  rhsTemp);
     }
    }
}

package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "*", 2); 
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "*";
    }

    /**
     * Evaluates the object. Multiply lhs to rhs if there are not any undeclared variables in any
     * of the sides.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new multiplication
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        SymbolicExpression rhsTemp = rhs.eval(vars);
        SymbolicExpression lhsTemp = lhs.eval(vars);
     if(lhsTemp.isConstant() && rhsTemp.isConstant()) {
      return new Constant(lhsTemp.getValue() * rhsTemp.getValue());
     }
     else if (lhs.isNamedConstant() && rhsTemp.isNamedConstant()) {
        return new Multiplication(lhsTemp, rhsTemp).eval(vars);
     }
     else if(lhsTemp.isConstant()) {
        if (rhsTemp.hasUndeclaredVariable(vars)) {
            return new Multiplication(lhsTemp, rhsTemp);
        } else {
            return new Multiplication(lhsTemp, rhsTemp).eval(vars);
        }
     }
     else if(rhsTemp.isConstant()) {
        if (lhsTemp.hasUndeclaredVariable(vars)) {
            return new Multiplication(lhsTemp, rhsTemp);
        } else {
            return new Multiplication(lhsTemp, rhsTemp).eval(vars);
        }
    }
    else {
      return new Multiplication(lhsTemp,  rhsTemp);
     }
    }
}

package org.ioopm.calculator.ast;

import java.lang.Math;

public class Sin extends Unary{
    
    public Sin(SymbolicExpression expression) {
        super(expression, "Sin");
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "Sin";
    }

    /**
     * Evaluates the object. Takes Sin of the evaluated expression if there are not any undeclared
     * variables in the expression.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new Sin
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        } else {
            return new Sin(arg);
        }
    }
}

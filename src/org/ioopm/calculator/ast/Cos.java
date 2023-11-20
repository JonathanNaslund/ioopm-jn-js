package org.ioopm.calculator.ast;

import java.lang.Math;

public class Cos extends Unary {
    
    public Cos(SymbolicExpression expression) {
        super(expression, "Cos");
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "Cos";
    }

    /**
     * Evaluates the object. Takes Cos of the evaluated expression if there are not any undeclared
     * variables in the expression.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new Cos
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.cos(arg.getValue()));
        } else {
            return new Cos(arg);
        }
    }
}

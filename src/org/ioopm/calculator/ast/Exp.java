package org.ioopm.calculator.ast;

import java.lang.Math;

public class Exp extends Unary {

    public Exp(SymbolicExpression expression) {
        super(expression, "Exp");
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "Exp";
    }

    /**
     * Evaluates the object. Takes e to the power of the evaluated expression if there
     * are not any undeclared variables in the expression.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new Exp
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.exp(arg.getValue()));
        } else {
            return new Exp(arg);
        }
    }
}

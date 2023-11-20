package org.ioopm.calculator.ast;

import java.lang.Math;

public class Log extends Unary {

    public Log(SymbolicExpression expression) {
        super(expression, "Log");
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "Log";
    }

    /**
     * Evaluates the object. Takes Log of the evaluated expression if there are not any undeclared
     * variables in the expression.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new Log
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        } else {
            return new Log(arg);
        }
    }
}

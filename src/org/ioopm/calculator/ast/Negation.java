package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression expression) {
        super(expression, "Neg");
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "Neg";
    }

    /**
     * Evaluates the object. Multiplies -1 to the evaluated expression if there are not any undeclared
     * variables in the expression.
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the evaluated object as either a new constant or a new Negation
     */
    @Override
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException{
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(-1 * arg.getValue());
        } else {
            return new Negation(arg);
        }
    }
}

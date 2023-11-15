package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression expression) {
        super(expression, "Neg");
    }

    @Override
    public String getName() {
        return "Neg";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(-1 * arg.getValue());
        } else {
            return new Negation(arg);
        }
    }
}

package org.ioopm.calculator.ast;

import java.lang.Math;

public class Exp extends Unary {

    public Exp(SymbolicExpression expression) {
        super(expression, "Exp");
    }

    @Override
    public String getName() {
        return "Exp";
    }

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

package org.ioopm.calculator.ast;

import java.lang.Math;

public class Cos extends Unary {
    
    public Cos(SymbolicExpression expression) {
        super(expression, "Cos");
    }

    @Override
    public String getName() {
        return "Cos";
    }

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

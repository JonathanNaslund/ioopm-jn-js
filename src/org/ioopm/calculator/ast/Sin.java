package org.ioopm.calculator.ast;

import java.lang.Math;

public class Sin extends Unary{
    
    public Sin(SymbolicExpression expression) {
        super(expression, "Sin");
    }

    @Override
    public String getName() {
        return "Sin";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        } else {
            return new Sin(arg);
        }
    }
}

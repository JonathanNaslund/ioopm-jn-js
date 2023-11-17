package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "+", 1);
    }

    @Override
    public String getName() {
        return "+";
    }
    @Override
    public SymbolicExpression eval(Environment vars) {
     SymbolicExpression tmpLhs = lhs.eval(vars);
     SymbolicExpression tmpRhs = rhs.eval(vars);
     if(tmpLhs.isConstant() && tmpRhs.isConstant()) {
      return new Constant(tmpLhs.getValue() + tmpRhs.getValue());
     }
     return new Addition(tmpLhs, tmpRhs);
    }
}

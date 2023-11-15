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
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() + rhs.getValue());
     }
     else if(lhs.isConstant()) {
      return new Addition(lhs, rhs.eval(vars));
     }
     else if(rhs.isConstant()) {
      return new Addition(lhs.eval(vars), rhs);
     }
     else {
      return new Addition(lhs.eval(vars),  rhs.eval(vars));
     }
    }
}

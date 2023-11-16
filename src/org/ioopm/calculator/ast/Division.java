package org.ioopm.calculator.ast;

public class Division extends Binary {
    
  public  Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "/", 2);
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression tempLhs = lhs.eval(vars);
	SymbolicExpression tempRhs = rhs.eval(vars);
	if(tempRhs.getValue() == 0) {
           throw new RuntimeException("Division by 0");
	}
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() / rhs.getValue());
     } else {
      return new Division(tempLhs,  tempRhs);
     }
    }
}

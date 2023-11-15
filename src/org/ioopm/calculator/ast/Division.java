package org.ioopm.calculator.ast;

public class Division extends Binary {
    
  public  Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "/", 2);
    }

    @Override
    public String getName() {
        return "/";
    }
    public SymbolicExpression eval() {
	SymbolicExpression tempLhs = lhs.eval();
	SymbolicExpression tempRhs = rhs.eval();
	if(tempRhs.getValue() == 0) {
           throw new RuntimeException("Division by 0");
	}
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() / rhs.getValue());
     }
     else if(lhs.isConstant()) {
      return new Division(tempLhs, tempRhs);
     }
     else if(rhs.isConstant()) {
      return new Division(tempLhs, tempRhs);
     }
     else {
      return new Division(tempLhs,  tempRhs);
     }
    }
}

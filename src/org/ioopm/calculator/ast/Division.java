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
    if(tempRhs.isConstant()) {
        if ((tempRhs).getValue() == 0) {
            throw new RuntimeException("Division by 0");
        }
	}
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() / rhs.getValue());
     }
     else if (lhs.isNamedConstant() && rhs.isNamedConstant()) {
        return new Division(lhs, rhs.eval(vars)).eval(vars);
     }
     else if(lhs.isConstant()) {
        if (rhs.hasUndeclaredVariable(vars)) {
            return new Division(lhs, rhs.eval(vars));
        } else {
            return new Division(lhs, rhs.eval(vars)).eval(vars);
        }
     }
     else if(rhs.isConstant()) {
        if (lhs.hasUndeclaredVariable(vars)) {
            return new Division(lhs.eval(vars), rhs);
        } else {
            return new Division(lhs.eval(vars), rhs).eval(vars);
        }
    }
    else {
      return new Division(lhs.eval(vars),  rhs.eval(vars));
     }
    }
}

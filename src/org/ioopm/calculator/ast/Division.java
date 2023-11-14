package org.ioopm.calculator.ast;

public class Division extends Binary {
    
  public  Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "/", 2);
    }

    @Override
    public String getName() {
        return "/";
    }
}

package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "*", 2); 
    }

    @Override
    public String getName() {
        return "*";
    }
    public SymbolicExpression eval() {
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() * rhs.getValue());
     }
     else {
      return new Multiplication(lhs,  rhs);
     }
    }
}

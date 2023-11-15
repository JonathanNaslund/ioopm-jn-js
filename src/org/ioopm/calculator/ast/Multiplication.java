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
    	SymbolicExpression tempLhs = lhs.eval();
	SymbolicExpression tempRhs = rhs.eval();
     if(tempLhs.isConstant() && tempRhs.isConstant()) {
      return new Constant(tempLhs.getValue() * tempRhs.getValue());
     }
     else if(tempLhs.isConstant()) {
	if(tempRhs.isVariable()) {
	      return new Multiplication(tempLhs, tempRhs).eval();
	} else if(tempRhs instanceof Unary) {
	      return new Multiplication(tempLhs, tempRhs).eval();
	} else {
		Binary tempBinary = (Binary) tempRhs;
		 if(tempBinary.getName() == "+") {
			 return new Addition(new Multiplication(tempLhs, tempBinary.lhs), new Multiplication(tempLhs, tempBinary.rhs)).eval();
		 }
		 else {
			 //(tempBinary.getName() == "-") {
			 return new Subtraction(new Multiplication(tempLhs, tempBinary.lhs), new Multiplication(tempLhs, tempBinary.rhs)).eval();
		 }
	}
     }
     else if(tempRhs.isConstant()) {
	if(tempLhs.isVariable()) {
	      return new Multiplication(tempLhs, tempRhs);
	} else if(tempLhs instanceof Unary) {
	      return new Multiplication(tempLhs, tempRhs).eval();
	} else {
		Binary tempBinary = (Binary) tempLhs;
		 if(tempBinary.getName() == "+") {
			 return new Addition(new Multiplication(tempBinary.lhs, tempRhs), new Multiplication(tempBinary.rhs, tempRhs)).eval();
		 }
		 else { 
			 //(tempBinary.getName() == "-") {
			 return new Subtraction(new Multiplication(tempBinary.lhs, tempRhs), new Multiplication(tempBinary.rhs, tempRhs));
		 }
	}
     }
     else {
      return new Multiplication(tempLhs, tempRhs);
     }
    }
}

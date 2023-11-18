package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "*", 2); 
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
     if(lhs.isConstant() && rhs.isConstant()) {
      return new Constant(lhs.getValue() * rhs.getValue());
     }
     else if (lhs.isNamedConstant() && rhs.isNamedConstant()) {
        return new Multiplication(lhs, rhs.eval(vars)).eval(vars);
     }
     else if(lhs.isConstant()) {
        if (rhs.hasUndeclaredVariable(vars)) {
            return new Multiplication(lhs, rhs.eval(vars));
        } else {
            return new Multiplication(lhs, rhs.eval(vars)).eval(vars);
        }
     }
     else if(rhs.isConstant()) {
        if (lhs.hasUndeclaredVariable(vars)) {
            return new Multiplication(lhs.eval(vars), rhs);
        } else {
            return new Multiplication(lhs.eval(vars), rhs).eval(vars);
        }
    }
    else {
      return new Multiplication(lhs.eval(vars),  rhs.eval(vars));
     }
    }


	// @Override
    // public SymbolicExpression eval(Environment vars) {
    // 	SymbolicExpression tempLhs = lhs.eval(vars);
	// SymbolicExpression tempRhs = rhs.eval(vars);
    //  if(tempLhs.isConstant() && tempRhs.isConstant()) {
    //   return new Constant(tempLhs.getValue() * tempRhs.getValue());
    //  }
    //  else if(tempLhs.isConstant()) {
	// if(tempRhs.isVariable()) {
	//       return new Multiplication(tempLhs, tempRhs).eval(vars);
	// } else if(tempRhs instanceof Unary) {
	//       return new Multiplication(tempLhs, tempRhs).eval(vars);
	// } else {
	// 	Binary tempBinary = (Binary) tempRhs;
	// 	 if(tempBinary.getName() == "+") {
	// 		 return new Addition(new Multiplication(tempLhs, tempBinary.lhs), new Multiplication(tempLhs, tempBinary.rhs)).eval(vars);
	// 	 }
	// 	 else {
	// 		 //(tempBinary.getName() == "-") {
	// 		 return new Subtraction(new Multiplication(tempLhs, tempBinary.lhs), new Multiplication(tempLhs, tempBinary.rhs)).eval(vars);
	// 	 }
	// }
    //  }
    //  else if(tempRhs.isConstant()) {
	// if(tempLhs.isVariable()) {
	//       return new Multiplication(tempLhs, tempRhs);
	// } else if(tempLhs instanceof Unary) {
	//       return new Multiplication(tempLhs, tempRhs).eval(vars);
	// } else {
	// 	Binary tempBinary = (Binary) tempLhs;
	// 	 if(tempBinary.getName() == "+") {
	// 		 return new Addition(new Multiplication(tempBinary.lhs, tempRhs), new Multiplication(tempBinary.rhs, tempRhs)).eval(vars);
	// 	 }
	// 	 else { 
	// 		 //(tempBinary.getName() == "-") {
	// 		 return new Subtraction(new Multiplication(tempBinary.lhs, tempRhs), new Multiplication(tempBinary.rhs, tempRhs)).eval(vars);
	// 	 }
	// }
    //  }
    //  else {
    //   return new Multiplication(tempLhs, tempRhs);
    //  }
    // }
}

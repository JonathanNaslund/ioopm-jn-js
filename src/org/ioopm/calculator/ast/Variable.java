package org.ioopm.calculator.ast;

public class Variable extends Atom {

    public Variable(String identifier) {
        super(identifier);
    }   

    public String toString() {
	    return this.getVariable();
    }

    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }
    
    public boolean equals(Variable other) {
        return getVariable().compareTo(other.getVariable()) == 0;
    }
    @Override
    public boolean isVariable() {
        return true;
    }
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = vars.get(getVariable());
        if (arg == null) {
            return new Variable(this.getVariable());
        } else if(arg instanceof Addition) {
            Addition tmp = (Addition) arg;
            return new Addition(tmp.lhs, tmp.rhs);
        } else if(arg instanceof Subtraction) {
            Subtraction tmp = (Subtraction) arg;
            return new Subtraction(tmp.lhs, tmp.rhs);
        } else if(arg instanceof Multiplication) {
            Multiplication tmp = (Multiplication) arg;
            return new Multiplication(tmp.lhs, tmp.rhs);
        } else if(arg instanceof Division) {
            Division tmp = (Division) arg;
            return new Division(tmp.lhs, tmp.rhs);
        } else if(arg instanceof Log) {
            Log tmp = (Log) arg;
            return new Log(tmp.expression);
        } else if(arg instanceof Sin) {
            Sin tmp = (Sin) arg;
            return new Sin(tmp.expression);
        } else if(arg instanceof Cos) {
            Cos tmp = (Cos) arg;
            return new Cos(tmp.expression);
        } else if(arg instanceof Exp) {
            Exp tmp = (Exp) arg;
            return new Exp(tmp.expression);
        } else if(arg instanceof Negation) {
            Negation tmp = (Negation) arg;
            return new Negation(tmp.expression);
        } else if(arg instanceof Variable) {
            Variable tmp = (Variable) arg;
            return new Variable(tmp.getName());
        } else {
            Constant tmp = (Constant) arg;
            return new Constant(tmp.getValue());
        }
    } 
}


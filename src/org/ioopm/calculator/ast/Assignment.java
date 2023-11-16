package org.ioopm.calculator.ast;

import java.util.Hashtable;

public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs, Environment vars) {
        super(lhs, rhs, "=", 1);
        if (rhs.isVariable()) {
            Variable tmpRhs = (Variable) rhs;
            vars.put(tmpRhs, lhs);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String getName() {
        return "=";
    }

    public SymbolicExpression eval(Environment vars){
        if (rhs.isVariable()) {
            SymbolicExpression arg = lhs.eval(vars);
            Variable tmpRhs = (Variable) rhs;
            if(arg instanceof Addition) {
                Addition tmp = (Addition) arg;
                Addition newExpression = new Addition(tmp.lhs, tmp.rhs);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Subtraction) {
                Subtraction tmp = (Subtraction) arg;
                Subtraction newExpression = new Subtraction(tmp.lhs, tmp.rhs);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Multiplication) {
                Multiplication tmp = (Multiplication) arg;
                Multiplication newExpression = new Multiplication(tmp.lhs, tmp.rhs);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Division) {
                Division tmp = (Division) arg;
                Division newExpression = new Division(tmp.lhs, tmp.rhs);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Log) {
                Log tmp = (Log) arg;
                Log newExpression = new Log(tmp.expression);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Sin) {
                Sin tmp = (Sin) arg;
                Sin newExpression = new Sin(tmp.expression);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Cos) {
                Cos tmp = (Cos) arg;
                Cos newExpression = new Cos(tmp.expression);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Exp) {
                Exp tmp = (Exp) arg;
                Exp newExpression = new Exp(tmp.expression);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Negation) {
                Negation tmp = (Negation) arg;
                Negation newExpression = new Negation(tmp.expression);
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else if(arg instanceof Variable) {
                Variable tmp = (Variable) arg;
                Variable newExpression = new Variable(tmp.getName());
                vars.put(tmpRhs, newExpression);
                return newExpression;
            } else {
                Constant tmp = (Constant) arg;
                Constant newExpression = new Constant(tmp.getValue());
                vars.put(tmpRhs, newExpression);
                return newExpression;
            }
        } else {
            throw new RuntimeException();
        }
    }
}

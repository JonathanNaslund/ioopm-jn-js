package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {
    private int priority = 0;
    public boolean isConstant() {
        return false;
    }
    public boolean isVariable() {
        return false;
    }

    public SymbolicExpression(int priority) {
        this.priority = priority;
     }

    public boolean isAtom() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }
    public double getValue() {
        throw new RuntimeException("getValue() called on something which is not a constant");
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public SymbolicExpression eval() {

        throw new RuntimeException("getValue() called on something which is not a constant");
    }
}

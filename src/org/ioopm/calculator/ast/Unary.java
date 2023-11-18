package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    protected SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        super(1);
        this.expression = expression;
        this.name = name;
    }
    public String toString() {
        return this.getName() + " (" + this.expression.toString() + ")";
    }

    public boolean equals(SymbolicExpression other) {
        if (other instanceof Unary) {
            Unary tmpBinary = (Unary) other;
            return (this.expression.equals(tmpBinary.expression)); 
        } else {
            return false;
        }
    }

    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return (expression.hasUndeclaredVariable(vars));
    }
}

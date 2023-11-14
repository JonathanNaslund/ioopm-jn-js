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
        if (!other.isAtom()) {
            if (this.name.compareTo(other.getName()) == 0) {
                Unary tmpBinary = (Unary) other;
                return (this.expression.equals(tmpBinary.expression)); 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

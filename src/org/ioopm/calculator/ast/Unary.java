package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    protected SymbolicExpression expression;
    private String name;

    public Unary(SymbolicExpression expression, String name) {
        super(1);
        this.expression = expression;
        this.name = name;
    }

    /**
     * Stringifies the operation
     * @return a string of the lhs and rhs with the operator inbetween
     */
    public String toString() {
        return this.getName() + " (" + this.expression.toString() + ")";
    }

    /**
     * Checks if this and an other object is equal by comparing lhs:s and rhs:s
     * @param other the other object to compare to
     * @return true if the two objects are equal, else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Unary) {
            Unary tmpBinary = (Unary) other;
            return (this.expression.equals(tmpBinary.expression)); 
        } else {
            return false;
        }
    }

    /**
     * Checks if there are any undeclared in lhs and rhs
     * @param vars A hashtable that holds declared variables and their values
     * @return true if there are atleast one undeclared variable in either lhs or rhs or both, else false
     */
    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return (expression.hasUndeclaredVariable(vars));
    }
}

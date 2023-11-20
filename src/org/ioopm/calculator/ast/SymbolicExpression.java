package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {
    private int priority = 0;

    /**
     * Returns false to notify the caller that the object is not a constant
     * @return false
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * Returns false to notify the caller that the object is not a variable
     * @return false
     */
    public boolean isVariable() {
        return false;
    }

    /**
     * The constructor of the class that changes the priority to the parameter
     * @param priority priority to change to
     */
    public SymbolicExpression(int priority) {
        this.priority = priority;
     }

    /**
     * Returns false to notify the caller that the object is not an atom
     * @return false
     */
    public boolean isAtom() {
        return false;
    }

    /**
     * Return false to notify the caller that the object is not a named constant
     * @return
     */
    public boolean isNamedConstant() {
        return false;
    }
    
    /**
     * Throws an exception when getName is called on a expression that does not have an operator.
     * Will be overrode if the subclass has an operator
     * @throws Runtimeexception if called on an expression that does not have a operator
     */
    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    /**
     * Throws an exception when getValue is called on a expression that is not a constant
     * @throws Runtimeexception if called on an expression that is not a constant
     */
    public double getValue() {
        throw new RuntimeException("getValue() called on something which is not a constant");
    }

    /**
     * Gets the priority of the expression
     * @return the priority
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the expression
     * @param the priority to set to
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Throws an exception if eval is called on a symbolicExpression that is 
     * not an operator. This will be overrode if for all subclasses that has operators. 
     * @param vars A hashtable that holds declared variables and their values
     * @throws RuntimeException if called on a symbolicExpression that does not have an operator
     */
    public SymbolicExpression eval(Environment vars) throws DivideByZeroException {
        throw new RuntimeException("Eval(vars) on something that is not an operator");
    }

    /**
     * Checks if this symbolicExpression has a undeclared variable or not
     * @param vars A hashtable that holds declared variables and their values
     * @return true if the expression contains an undeclared variable, else false
     */
    public boolean hasUndeclaredVariable(Environment vars) {
        return this.hasUndeclaredVariable(vars);
    }
}

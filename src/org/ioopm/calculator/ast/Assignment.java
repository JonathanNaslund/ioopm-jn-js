package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs, Environment vars) {
        super(lhs, rhs, "=", 1);
        this.eval(vars);
    }

    /**
     * @return returns the name of operation in as string
     */
    @Override
    public String getName() {
        return "=";
    }

    /**
     * Declares a value to a variable and puts the pair in a hashtable to hold key(variable)-value pair
     * @param vars A hashtable that holds declared variables and their values
     * @return Returns the object
     * @throws IllegalExpressionException if rhs is a named constant
     * @throws RuntimeException if rhs is not a variable or a named constant
     */
    @Override
    public SymbolicExpression eval(Environment vars){
        if (rhs.isVariable()) {
            vars.put((Variable)rhs, lhs);
            return this;
        } else if (rhs instanceof NamedConstant) {
            throw new IllegalExpressionException("Error: cannot redefine named constant!");
        } else {
            throw new RuntimeException("Error: cannot assign to non-variable!");
        }
    }
}

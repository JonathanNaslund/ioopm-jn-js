package org.ioopm.calculator.ast;

import java.lang.Math;
import java.util.HashMap; 

public class NamedConstant extends SymbolicExpression{
    public static final HashMap<String, Double> namedConstants = new HashMap<>();
    private String variable;
    private double value;

    static {
        NamedConstant.namedConstants.put("pi", Math.PI);
        NamedConstant.namedConstants.put("e",  Math.E);
        NamedConstant.namedConstants.put("L", 6.022140857*Math.pow(10, 23));
        NamedConstant.namedConstants.put("Answer", (double)42);

    }

    public NamedConstant(String name, double value) {
        super(0);
        NamedConstant.namedConstants.put(name, value);
        this.variable = name;
        this.value = value;
    }

    /**
     * Gets the name of the named constant
     * @return the name of the named constant
     */
    @Override
    public String toString() {
        return variable;
    }

    /**
     * Creates and returns a new constant with the value of the named constant
     * @param vars A hashtable that holds declared variables and their values
     * @return a new constant
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        return new Constant(value);
    }

    /**
     * Returns false to show caller that this branch of the tree does not
     * have a undeclared variable.
     * @param vars A hashtable that holds declared variables and their values
     * @return false
     */
    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return false;
    }

    /**
     * Returns true to show the caller that this object is a named contant
     * @return true
     */
    @Override
    public boolean isNamedConstant() {
        return true;
    }
}
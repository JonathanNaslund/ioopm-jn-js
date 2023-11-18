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
        // Constants.namedConstants.put("Answer", );

    }

    public NamedConstant(String name, double value) {
        super(0);
        this.variable = name;
        this.value = value;
    }

    public String getVariable() {
        return this.variable;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        return new Constant(value);
    }

    @Override
    public boolean hasUndeclaredVariable(Environment vars) {
        return false;
    }

    @Override
    public boolean isNamedConstant() {
        return true;
    }
}
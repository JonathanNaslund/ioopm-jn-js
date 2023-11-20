package org.ioopm.calculator.ast;

public abstract class Atom extends SymbolicExpression{
    private String variable;
    private double value;

    public Atom(double value) {
        super(1);
        this.value = value;
    }

    public Atom(String variable) {
        super(1);
        this.variable = variable;
    }

    /**
     * Gets the variable of the atom
     * @return the variable
     */
    	public String getVariable() {
		return variable;
	}

    /**
     * Gets the value of the atom
     * @return the value
     */
	public double getValue() {
		return value;
	}
    
    /**
     * Returns true to show the caller that this object is an atom
     * @return true
     */
    @Override
    public boolean isAtom() {
        return true;
    }
}

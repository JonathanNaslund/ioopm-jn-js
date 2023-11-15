package org.ioopm.calculator.ast;

public abstract class Atom extends SymbolicExpression{
    private String variable;
    private double value;
    public Atom(double value) {
        super(100);
        this.value = value;
    }

    public Atom(String variable) {
        super(100);
        this.variable = variable;
    }
	public String getVariable() {
		return variable;
	}
	public double getValue() {
		return value;
	}
    

    @Override
    public boolean isAtom() {
        return true;
    }
}

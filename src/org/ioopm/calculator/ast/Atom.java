package org.ioopm.calculator.ast;

public class Atom extends SymbolicExpression{
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
    @Override
    public boolean isAtom() {
        return true;
    }
}

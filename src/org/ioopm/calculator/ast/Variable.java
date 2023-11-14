package org.ioopm.calculator.ast;

public class Variable extends Atom {

    public Variable(String identifier) {
        super(identifier);
    }   
    public String toString() {
	    return this.getVariable();
    }
}

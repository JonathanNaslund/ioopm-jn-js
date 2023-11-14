package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Atom extends SymbolicExpression{
    private SymbolicExpression value;
    
    public Atom(SymbolicExpression value) {
        // super(priority);
        this.value = value;
    }
}

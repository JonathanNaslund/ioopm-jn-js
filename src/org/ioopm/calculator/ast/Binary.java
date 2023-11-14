package org.ioopm.calculator.ast;

import AST.SymbolicExpression;
import AST.Atom.Variable;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;
    private String name;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs, String name) {
        // super(priority);
        this.lhs = lhs;
        this.rhs = rhs;
        this.name = name;
    }
}

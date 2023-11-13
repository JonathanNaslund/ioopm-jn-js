package AST.Binary;

import AST.SymbolicExpression;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;
}

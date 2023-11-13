package AST.Binary;

import AST.SymbolicExpression;

public class Addition extends Binary {

    Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "+");
    }

    @Override
    public String getName() {
        return "+";
    }
}

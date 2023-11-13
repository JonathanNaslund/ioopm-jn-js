package AST.Binary;

import AST.SymbolicExpression;

public class Multiplication extends Binary {
    
    Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "*");
    }

    @Override
    public String getName() {
        return "*";
    }
}

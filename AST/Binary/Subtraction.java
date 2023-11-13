package AST.Binary;

import AST.SymbolicExpression;

public class Subtraction extends Binary {
    
    Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "-");
    }

    @Override
    public String getName() {
        return "-";
    }
}

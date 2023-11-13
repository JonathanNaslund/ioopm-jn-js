package AST.Binary;

import AST.SymbolicExpression;

public class Division extends Binary {
    
    Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs, "/");
    }

    @Override
    public String getName() {
        return "/";
    }
}

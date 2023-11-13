package AST.Atom;

import AST.SymbolicExpression;

public class Constant extends Atom {

    public Constant(SymbolicExpression value) {
        super(value);
    }

    @Override
    public boolean isConstant() {
        return true;
    }
}

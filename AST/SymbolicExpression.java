package AST;

public abstract class SymbolicExpression {
    // private int priority = 0;
    public boolean isConstant() {
        return false;
    }

    // public SymbolicExpression(int priority) {
    //     this.priority = priority;
    // }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }
}

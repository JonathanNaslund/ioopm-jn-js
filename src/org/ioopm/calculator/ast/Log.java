package org.ioopm.calculator.ast;

public class Log extends Unary {

    public Log(SymbolicExpression expression) {
        super(expression, "Log");
    }

    @Override
    public String getName() {
        return "Log";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.expression.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        } else {
            return new Log(arg);
        }
    }
}

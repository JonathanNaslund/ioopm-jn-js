package org.ioopm.calculator.ast;

import AST.SymbolicExpression;

public class Log extends Unary {

    public Log(SymbolicExpression expression) {
        super(expression, "Log");
    }

    @Override
    public String getName() {
        return "Log";
    }
}

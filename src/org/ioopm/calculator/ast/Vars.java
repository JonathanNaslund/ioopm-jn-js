package org.ioopm.calculator.ast;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    public void printVariables(Environment vars) {
        vars.forEach((Variable key, SymbolicExpression value) -> {
            System.out.println(key.getVariable() + " = " + value.toString());
        });
    }
}

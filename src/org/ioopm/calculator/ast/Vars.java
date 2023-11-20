package org.ioopm.calculator.ast;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    /**
     * Prints all variables and respective values, one key-value pair per row. Ex. x = 5
     * @param vars A hashtable that holds declared variables and their values
     */
    public void printVariables(Environment vars) {
        vars.forEach((Variable key, SymbolicExpression value) -> {
            System.out.println(key.getVariable() + " = " + value.toString());
        });
    }
}

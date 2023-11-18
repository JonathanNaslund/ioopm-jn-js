package org.ioopm.calculator.ast;

public class Clean extends Command {
    public Clean() {
        super();
    }

    public void cleanVariables(Environment vars) {
        vars.clear();
    }
}

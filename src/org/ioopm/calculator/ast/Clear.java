package org.ioopm.calculator.ast;

public class Clear extends Command{
    private static final Clear theInstance = new Clear();
    private Clear() {}
    public static Clear instance() {
        return theInstance;
    }

    /**
     * Clears the enviroment(hashtable) of all key-value pairs
     * @param vars A hashtable that holds declared variables and their values
     */
    public void clearVariables(Environment vars) {
        vars.clear();
    }
}

package org.ioopm.calculator.ast;

public class Quit extends Command {
    private static final Quit theInstance = new Quit();
    private Quit() {}
    public static Quit instance() {
        return theInstance;
    }

    /**
     * Returns false if called
     * @return false
     */
    public boolean quitEventloop() {
        return false;
    }
}

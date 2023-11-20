package org.ioopm.calculator.ast;

public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

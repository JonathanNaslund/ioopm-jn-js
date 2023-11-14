package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    protected SymbolicExpression lhs = null;
    protected SymbolicExpression rhs = null;
    private String name;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs, String name, int priority) {
        super(priority);
        this.lhs = lhs;
        this.rhs = rhs;
        this.name = name;
        changePriority();
    }

    private void changePriority() {
        if (this.name == "*" || this.name == "/") {
            if (!lhs.isAtom() && !rhs.isAtom()) {
                String lhsSymbol = lhs.getName();
                String rhsSymbol = rhs.getName();
                if ((lhsSymbol == "+" || lhsSymbol == "-") && (rhsSymbol == "+" || rhsSymbol == "-")) {
                    lhs.setPriority(3);
                    rhs.setPriority(3);
                } else if (lhsSymbol == "+"|| lhsSymbol == "-") {
                    lhs.setPriority(3);
                } else if (rhsSymbol == "+"|| rhsSymbol == "-") {
                    rhs.setPriority(3);
                }
            } else if (!lhs.isAtom()) {
                String lhsSymbol = lhs.getName();
                if (lhsSymbol == "+"|| lhsSymbol == "-") {
                    lhs.setPriority(3);
                }
            } else if (!rhs.isAtom()) {
                String rhsSymbol = rhs.getName();
                if (rhsSymbol == "+"|| rhsSymbol == "-") {
                    lhs.setPriority(3);
                }
            }
        } else if (this.name == "-" && !rhs.isAtom()) {
            if (rhs.getName() == "+") {
                rhs.setPriority(3);
            }
        }
    }

    public String toString() {
	    if(getPriority() == 3) {
	    	return "(" + lhs.toString() + " " + this.getName() + " " + rhs.toString() + ")";
	    } else {
	    	return lhs.toString() + " " + this.getName() + " " + rhs.toString();
	    }
    }

    public boolean equals(SymbolicExpression other) {
        if (!other.isAtom()) {
            if (this.name.compareTo(other.getName()) == 0) {
                Binary tmpBinary = (Binary) other;
                return (this.lhs.equals(tmpBinary.lhs) && this.rhs.equals(tmpBinary.rhs)); 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

import org.ioopm.calculator.ast.*;

public class Test {
    public void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
        // SymbolicExpression r = e.eval();
        if (e.equals(expected)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }
 public static void main(String[] args) {
  Constant c1 = new Constant(5);
  Constant c2 = new Constant(2);
  //System.out.println("C2: " + c2.toString());
  Variable v = new Variable("x");
  Addition a = new Addition(c1, v);
  Multiplication m = new Multiplication(a, c2);
  System.out.println("(5 + x) * 2 ==> " + m.toString());
 }
}

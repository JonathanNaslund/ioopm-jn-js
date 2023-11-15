import org.ioopm.calculator.ast.*;

public class Test {
    static void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
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

  System.out.println("(5 + x) * 2 ==> " + m.eval().toString());

  Constant c3 = new Constant(5);
  Constant c4 = new Constant(2);
  //System.out.println("C2: " + c2.toString());
  Variable g = new Variable("x");
  Addition b = new Addition(c3, g);
  Multiplication n = new Multiplication(b, c4);

  //testEvaluating(n, m);

  Constant c5 = new Constant(5);
  Constant c6 = new Constant(2);
  Addition c = new Addition(c5, c6);
  Multiplication k = new Multiplication(c5, c6);
  System.out.println("5 + 2 ==> " + c.eval().toString());
  System.out.println("5 * 2 ==> " + k.eval().toString());
 }
}

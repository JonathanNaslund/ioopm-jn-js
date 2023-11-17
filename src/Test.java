import org.ioopm.calculator.ast.*;

import ast.Addition;
import ast.Assignment;
import ast.Constant;
import ast.Multiplication;
import ast.SymbolicExpression;
import ast.Variable;
import ast.Vars;

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
    Environment vars = new Environment();
  Constant c1 = new Constant(5);
  Constant c2 = new Constant(2);
  //System.out.println("C2: " + c2.toString());
  Variable v = new Variable("x");
  Addition a = new Addition(c1, v);
  Multiplication m = new Multiplication(a, c2);

  System.out.println("(5 + x) * 2 ==> " + m.eval(vars).toString());

  Constant c3 = new Constant(5);
  Constant c4 = new Constant(2);
  //System.out.println("C2: " + c2.toString());
  Variable g = new Variable("x");
  Addition b = new Addition(c3, g);
  Multiplication n = new Multiplication(b, c4);

  //testEvaluating(n, m);

//   Constant c5 = new Constant(5);
//   Constant c6 = new Constant(2);
//   Addition c = new Addition(c5, c6);
//   Multiplication k = new Multiplication(c5, c6);
//   System.out.println("5 + 2 ==> " + c.eval(vars).toString());
//   System.out.println("5 * 2 ==> " + k.eval(vars).toString());
//   Constant c7 = new Constant(5);
//   Constant c8 = new Constant(0);
//   Division D = new Division(c7, c8);
//   System.out.println(D.eval(vars).toString());

  Constant c5 = new Constant(5);
  Constant c6 = new Constant(2);
  Constant c7 = new Constant(10);
  //System.out.println("C2: " + c2.toString());
  Variable v2 = new Variable("y");
  Variable v3 = new Variable("z");
  Assignment as1 = new Assignment(c7, v2, vars);
  Assignment as2 = new Assignment(v2, v3, vars);
  Addition a2 = new Addition(v3, v2);
//   Addition a2 = new Addition(c5, v2);
  Multiplication m2 = new Multiplication(a2, c6);
  Vars.instance().printVariables(vars);
  System.out.println("(5 + y) * 2 ==> " + m2.eval(vars).toString());

 }
}

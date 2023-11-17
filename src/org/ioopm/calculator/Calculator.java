import java.util.Scanner;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
public class Calculator {
 public static void main(String[] args) {
  Environment vars = new Environment();
  CalculatorParser parser = new CalculatorParser();
  String inputStr = "";
  do {
   Scanner sc = new Scanner(System.in);
   System.out.print("");
   inputStr = sc.nextLine();
   SymbolicExpression expr = null;
   try {expr = parser.parse(inputStr, vars); }
   catch(Exception IOException) {
	   System.out.println("Something went wrong");
   }
   if (expr != null)  {
   SymbolicExpression evaled = expr.eval(vars);
   System.out.println(evaled.toString());
   }
  } while(inputStr.compareTo("Quit")!=0);
 }
}

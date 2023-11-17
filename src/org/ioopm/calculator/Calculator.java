import java.util.Scanner;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
public class Calculator {
 public static void main(String[] args) {
  Environment vars = new Environment();
  CalculatorParser parser = new CalculatorParser();
  String inputStr;
  do {
   Scanner sc = new Scanner(System.in);
   System.out.print("");
   inputStr = sc.nextLine();
   SymbolicExpression expr =parser.parse(inputStr, vars);
   SymbolicExpression evaled = expr.eval();
   System.out.println(evaled.toString());
  } while(inputStr.compareTo("Quit")==0);
 }
}

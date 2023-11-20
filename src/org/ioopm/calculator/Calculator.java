package org.ioopm.calculator;

import java.io.IOException;
import java.util.Scanner;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
public class Calculator {
 public static void main(String[] args) {
  Environment vars = new Environment();
  CalculatorParser parser = new CalculatorParser();
  String inputStr;
  Boolean keepGoing = true;
  do {
    System.out.print("Please enter an expression: ");
   Scanner sc = new Scanner(System.in);
   System.out.print("");
   inputStr = sc.nextLine();
   SymbolicExpression expr = null;
   try {expr = parser.parse(inputStr, vars); }
   catch(IOException IOException) {
	   System.out.println("Something went wrong");
   }
   if (expr instanceof Command) {
    if (expr instanceof Quit) {
        keepGoing = ((Quit)expr).quitEventloop();
    } else if (expr instanceof Vars) {
        ((Vars)expr).printVariables(vars);
    } else if (expr instanceof Clear) {
        ((Clear)expr).clearVariables(vars);
    }
   }
   else if (expr != null)  {
    SymbolicExpression evaled = expr.eval(vars);
    System.out.println(evaled.toString());
   }
  } while(keepGoing);
 }
}

package org.ioopm.calculator;

import java.io.IOException;
import java.util.Scanner;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
public class Calculator {
 public static void main(String[] args) {
  int enterCounter = 0;
  int evaledCounter = 0;
  int fullyCounter = 0;
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
   catch(DivideByZeroException e) {
        System.out.println("Can't divide by 0");
   }
   if (expr instanceof Command) {
    if (expr instanceof Quit) {
        keepGoing = ((Quit)expr).quitEventloop();
    } else if (expr instanceof Vars) {
        ((Vars)expr).printVariables(vars);
        new NamedConstant(inputStr, 0);
    } else if (expr instanceof Clear) {
        ((Clear)expr).clearVariables(vars);
    }
   }
   else if (expr != null)  {
    try {
        SymbolicExpression evaled = expr.eval(vars); 
        if (!(expr instanceof Assignment)) {
            vars.put(new Variable("Ans"), evaled);
            if (evaled.isConstant()) {
                fullyCounter++;
                evaledCounter++;
            } else {
                evaledCounter++;
            } 
        } 
        enterCounter ++;
        System.out.println(evaled.toString());}
    catch(DivideByZeroException e) {
        System.out.println("Can't divide by 0");
    }
   }
  } while(keepGoing);
  System.out.println("\nEntered expressions: " + enterCounter);
  System.out.println("Succesfully evaluated expression: " + evaledCounter);
  System.out.println("Fully evaluated expression: " + fullyCounter + "\n");
 }
}

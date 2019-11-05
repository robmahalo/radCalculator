/**
 * author: Robby
 * Version 1.0
 * 7/1/19
 * 
 */

package calc;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

// this class forms the Controller part of an MVC
public class StackCalculatorController {
	
	// this function receives an expression and returns the result of the expression
	public static double evaluate(String expression) {
		// validate the expression first
		if (expression == null || expression.length() == 0)
			throw new RuntimeException("Invlalid Expression");
		
		// create Stacks to store the operand and the operator
		Stack<String> operator = new Stack<String>();
		Stack<String> operand = new Stack<String>();
		
		// create a Scanner to extract tokens from the expression
		Scanner parse = new Scanner(expression);
		
		// extract each token and push it to its respective Stack
		while (parse.hasNext()) {
			String token = parse.next();

			// this means that it is an operand
			if ("+-*/".contains(token)) {
				operator.push(token);
			} else {
				// Otherwise, assume it to be a correct operand
				operand.push(token);
			}
		}
		
		// reverse the stacks because while pushing the inputs have been reversed
		Collections.reverse(operator);
		Collections.reverse(operand);
		
		parse.close();
		
		// keep evaluating till all operators have been evaluated
		while (!operator.isEmpty()) {
			try {
				String op = operator.pop();

				String operand1 = operand.pop();
				String operand2 = operand.pop();

				switch (op) {
				case "+":
					// add the operands and push back to the stack
					operand.push("" + (Double.parseDouble(operand1) + Double.parseDouble(operand2)));
					break;
				case "-":
					// perform subtraction and push the result back to the stack
					operand.push("" + (Double.parseDouble(operand1) - Double.parseDouble(operand2)));
					break;
				case "/":
					// perform division and push the result back to the stack
					if (Double.parseDouble(operand2) == 0)
						throw new ArithmeticException();
					operand.push("" + (Double.parseDouble(operand1) / Double.parseDouble(operand2)));
					break;
				case "*":
					// perform multiplication and push the result back to the stack
					operand.push("" + (Double.parseDouble(operand1) * Double.parseDouble(operand2)));
					break;
				}
			} catch (Exception e) {
				throw new RuntimeException("Invalid Expression");
			}
		}
		
		// return the resultant value
		return Double.parseDouble(operand.pop());
	}
}

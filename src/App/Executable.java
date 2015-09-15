package App;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Executable {
	public static int evaluate(String composition) {
		Queue output = postfix(composition);
		return calculate(output);
	}

	/*
	 * Implementing Shunting Yard Algorithm
	 */
	private static Queue<String> postfix(String input) {
		Queue<String> outputQueue = new LinkedList<>();
		Stack<String> operatorStack = new Stack<>();
		boolean bottomOperator = false;
		// TO DO: change the REGEX to exclude ', '
		for (String token : input.split(" ")) {

			// operator
			if (ops.containsKey(token)) {
				while (!operatorStack.isEmpty() && isHigherPrecedence(token, operatorStack.peek())) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.push(token);

				// left parenthesis
			} else if (token.equals("(")) {
				operatorStack.push(token);

				// right parenthesis
			} else if (token.equals(")")) {
				while (!operatorStack.peek().equals("(")) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.pop();

				// digit || function
			} else {
				outputQueue.add(token);
			}
		}

		// While we have operators
		while (!operatorStack.isEmpty()) {
			outputQueue.add(operatorStack.pop());
		}

		return outputQueue;
	}

	/*
	 * Implementing Postfix Calculator Algorithm
	 */
	private static int calculate(Queue<String> postfix) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		while (!postfix.isEmpty()) {
			if (ops.containsKey(postfix.peek()) && !stack.isEmpty()) {
				int rightInt = stack.pop();
				int leftInt = stack.pop();
				// Get the result
				result = postfix.peek().compareTo("*") == 0 ? leftInt * rightInt
						: postfix.peek().compareTo("/") == 0 ? leftInt / rightInt
								: postfix.peek().compareTo("+") == 0 ? leftInt + rightInt : leftInt - rightInt;

				// Add the result to the stack
				stack.add(result);
				// remove the operator from the postfix queue
				postfix.poll();
			} else {
				if (isInteger(postfix.peek())) {
					stack.add(Integer.parseInt(postfix.poll()));
				} else {
					System.out.println("Execute argument: " + postfix.peek());
					String[] argArray = postfix.poll().split("\\(", 2); //Splitting the string only in 2 parts
					String subArgs = "";
					// remove the right parenthesis
					if (argArray.length > 1) {
						subArgs = argArray[1].substring(0, argArray[1].length() - 1);
					}
					int arg = getTheArgument(argArray[0]).evaluate(subArgs);
					stack.add(arg);
				}
			}
		}
		if (!stack.isEmpty()) {
			result = stack.pop();
		}
		return result;
	}

	private static enum Operator {
		ADD(1), SUBSTRACT(2), MULTIPLY(3), DIVIDE(4);
		final int precedence;

		Operator(int p) {
			precedence = p;
		}
	}

	private static Map<String, Operator> ops = new HashMap<String, Operator>() {
		{
			put("+", Operator.ADD);
			put("-", Operator.SUBSTRACT);
			put("*", Operator.MULTIPLY);
			put("/", Operator.DIVIDE);
		}
	};

	private static boolean isHigherPrecedence(String operator, String sub) {
		return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(operator).precedence);
	}

	public static boolean isInteger(String token) {
		for (char letter : token.toCharArray()) {
			if (!Character.isDigit(letter)) {
				return false;
			}
		}
		return true;
	}

	private static Argument getTheArgument(String token) {
		if (Context.allArgs.containsKey(token)) {
			return Context.allArgs.get(token);
		}
		System.err.println("The argument '" + token + "' is undefined.");
		return null;
	}

}

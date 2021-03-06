package App;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//evaluateNextLine(scanner);
	}


	public static void evaluateNextLine(String input){
		Argument a = new Variable("var integer a = 5;");
		Argument b = new Variable("var integer b = 6;");
		Context.allArgs.put("b", b);
		Context.allArgs.put("a", a);
		Argument newF1 = new Function("def inc (integer -> integer) x = x + 1");
		Argument newF2 = new Function("def squareSum (integer -> integer -> integer) x y = x * 2 + y * 2");
		Context.allArgs.put("inc", newF1);
		Context.allArgs.put("squareSum", newF2);
		System.out.println(Context.allArgs.toString());

		String nextLine = input.trim();
		String firstStr = nextLine.split(" ")[0];
		switch (firstStr) {
			case "var":
				Argument newVar = new Variable(nextLine);
				Context.allArgs.put(newVar.getName(), newVar);
				break;
			case "def":
				Argument newF = new Function(nextLine);
				System.out.println(newF.getName());
				Context.allArgs.put(newF.getName(), newF);
				break;
			case "":
				break;
			default:
				int result = Executable.evaluate(nextLine);
				System.out.println("Result: " + result);

		}
	}

	/*
	 * Output examples:
	 * ( 5 + 7 ) * 2 // 5 7 + 2 * --> 24
	 * 5 + 7 / 2 // 5 7 2 / +  --> 8
	 * ( 10 + 5 ) / ( 8 / ( 2 + 2 ) + 1 )
	 * a
	 * inc(b)
	 * squareSum(inc(a),inc(b))
	 */
}

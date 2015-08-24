package App;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		evaluateNextLine(scanner);
	}
	
	private static void evaluateNextLine(Scanner scanner){
		String nextLine = scanner.nextLine().trim();
		String firstStr = nextLine.split(" ")[0];
		switch(firstStr){
			case "var": 
				Argument newVar = new Variable(nextLine);
				Context.allArgs.put(newVar.getName(), newVar);
				break;
			case "def":
				Argument newF = new Function(nextLine);
				Context.allArgs.put(newF.getName(), newF);
				break;
			default:
				Executable newExecution = new Executable(nextLine);
				newExecution.evaluate();
		}
		System.out.println(Context.allArgs.toString());
		evaluateNextLine(scanner);
	}
	
	/*
	 * Output examples:
	 * 	( 5 + 7 ) * 2 // 5 7 + 2 *
	 * 	5 + 7 / 2    // 5 7 2 / +
	 * */

}

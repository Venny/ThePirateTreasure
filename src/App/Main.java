package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Argument> allFuncs = new ArrayList<>();
		evaluateNextLine(scanner);
	}
	
	private static void evaluateNextLine(Scanner scanner){
		String nextLine = scanner.nextLine();
		System.out.println(nextLine);
		evaluateNextLine(scanner);
	}

}

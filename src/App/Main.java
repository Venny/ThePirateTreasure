package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int funcCount = Integer.parseInt(scanner.nextLine());
		ArrayList<Function> allFuncs = new ArrayList<>();
		
		for(int i = 0; i < funcCount; i++){
			String nextFunc = scanner.nextLine();
			Function func = new Function(nextFunc);
			allFuncs.add(func);
		}
	}

}

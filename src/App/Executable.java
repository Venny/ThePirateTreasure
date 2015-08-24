package App;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Executable {
	private String composition;
	
	public Executable(String composition){
		this.composition = composition;
	}
	
	public int evaluate(){
		String[] tokens = composition.trim().split(" ");
		Queue output = postfix(composition);
		
		System.out.println(output.toString() + " ......");
		return 0;
	}
	
	private boolean isInteger(String token){
		for(char letter:token.toCharArray()){
			if(!Character.isDigit(letter)){
				return false;
			}
		}
		return true;
	}
	
	private boolean isRealFunction(String token){
		return false;
	}
	
    /*
     * Implementing Shunting Yard Algorithm
     */
    private Queue postfix(String input){
    	Queue<String> outputQueue = new LinkedList<>();
    	Stack<String> operatorStack = new Stack<>();
    	boolean bottomOperator = false;
    	
    	for(String token:input.split(" ")){
    		
    		// operator
    		if(ops.containsKey(token)){
    				while( !operatorStack.isEmpty() && isHigerPrecedence(token, operatorStack.peek()) ){
        				outputQueue.add(operatorStack.pop());
        			}
    				operatorStack.push(token);		
    			
    		// left parenthesis
    		} else if(token.equals("(")){
    			operatorStack.push(token);
    		
    		// left parenthesis
    		} else if(token.equals(")")){
    			while(!operatorStack.peek().equals("(")){
    				outputQueue.add(operatorStack.pop());
    			}
    			operatorStack.pop();
    			
    		// digit || function
    		} else{
    			outputQueue.add(token);
    		}    		
    	}
    	
    	// While we have operators
		while(!operatorStack.isEmpty()){
			outputQueue.add(operatorStack.pop());
		}
		
    	return outputQueue;
    }

	private enum Operator {
		ADD(1), SUBSTRACT(2), MULTIPLY(3), DIVIDE(4);
		final int precedence;
		Operator(int p){
			precedence = p;
		}
	}
	
	private Map<String, Operator> ops = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBSTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};
    
    private boolean isHigerPrecedence(String operator, String sub){
    	return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(operator).precedence);
    }
    
}

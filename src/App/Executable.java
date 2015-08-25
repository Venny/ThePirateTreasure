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
		Queue output = postfix(composition);
		System.out.println(output.toString());
		int result = calculate(output);
		System.out.println(output.toString() + " ......" + result);
		return result;
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
    private Queue<String> postfix(String input){
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
    
	
	/*
     * Implementing Postfix Calculator Algorithm
     */
	private int calculate(Queue<String> postfix){
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		while(!postfix.isEmpty()){
			if(ops.containsKey(postfix.peek()) && !stack.isEmpty()){
				int rightInt = stack.pop();
				int leftInt = stack.pop();
				// Get the result
				result = postfix.peek().compareTo("*") == 0 ? leftInt * rightInt :   
						 postfix.peek().compareTo("/") == 0 ? leftInt / rightInt :  
						 postfix.peek().compareTo("+") == 0 ? leftInt + rightInt :  
															  leftInt - rightInt; 
				
				// Add the result to the stack
				stack.add(result);
				// remove the operator from the postfix queue
				postfix.poll(); 
			} else {
				if(isInteger(postfix.peek())){
					stack.add(Integer.parseInt(postfix.poll()));
				}
				// TO DO - add code for presenting custom functions
			}
		}
		return result;		
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

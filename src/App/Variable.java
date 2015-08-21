package App;

public class Variable {
	private String source;
	private String type;
	private String name;
	private String argumentName;

	
	public Variable(String source){
		this.source = source;
	}
	
	public String getName(){
		return name;
	}
	
	public String getArgumentName(){
		return argumentName;
	}
	
	public int evaluate(int x){
		return x;
	}
}

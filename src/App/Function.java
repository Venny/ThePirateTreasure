package App;

public class Function {
	private String source;
	private String type;
	private String name;
	private String argumentName;
	
	public Function(String source){
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

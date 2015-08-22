package App;

public abstract class Argument {
	protected String source;
	protected String name;
	protected String body;
	protected String type;
	

    public Argument(String source){
        this.source = source;
        String[] fParts = source.split(" = ");
        this.body = fParts[1];
       
    }

    public String toString(){
    	return " (" + type + "): " + body;
    };
    
    public String getName(){
    	return name;
    };
    
    public String getBody(){
    	return body;
    }
    
    public String getType(){
    	return type;
    }
    
    public abstract int evaluate(int x);
}

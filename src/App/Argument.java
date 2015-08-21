package App;

public abstract class Argument {
	private String source;
	

    public Argument(String source){
        this.source = source;
    }

    public abstract String getName();
    public abstract String getArgumentName();
    public abstract int evaluate(int x);
}

package App;

public class Variable extends Argument {
	private String argumentName;
	
	public Variable(String source) {
		super(source);
		String[] fParts = source.split(" = ")[0].split(" ");
		super.type = fParts[1];
		super.name = fParts[2];
		this.argumentName = super.name;
	}

	@Override
	public int evaluate(int[] args) {
		return 0;
	}
	
}

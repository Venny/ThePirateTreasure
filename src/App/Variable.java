package App;

public class Variable extends Argument {

	public Variable(String source) {
		super(source);
		String[] fParts = source.split(" = ")[0].split(" ");
		super.type = fParts[1];
		super.name = fParts[2];
		System.out.println(fParts[0] + " " + type + " " + name);
	}

	@Override
	public int evaluate(int x) {
		return 0;
	}
	
}

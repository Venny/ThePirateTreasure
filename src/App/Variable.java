package App;

public class Variable extends Argument {

	public Variable(String source) {
		super(source);
		String[] fParts = source.split(" = ")[0].split(" ");
		super.type = fParts[1];
		super.name = fParts[2];
	}

	@Override
	public int evaluate(String args) {
		if (Executable.isInteger(body)) {
			return Integer.parseInt(body);
		}
		return Executable.evaluate(body);
	}

}

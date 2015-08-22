package App;


public class Function extends Argument {
	private String argumentName;
	
	public Function(String source) {
		super(source);
		super.name = source.split(" ")[1];
		String fParts1 = source.split( "\\(" )[1];
		super.type = fParts1.split("\\)")[0];
	}

	@Override
	public int evaluate(int x) {
		return 0;
	}
}

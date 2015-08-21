package App;

public class Function extends Argument {
	private String source;
	private String type;
	private String name;
	private String argumentName;
	
	public Function(String source) {
		super(source);
		this.source = source;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getArgumentName() {
		return null;
	}

	@Override
	public int evaluate(int x) {
		return 0;
	}
}

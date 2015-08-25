package App;


public class Function extends Argument {
	private String argumentName;
	
	public Function(String source) {
		super(source);
		
		String fPart = source.split( "\\(" )[1];
		String[] fParts2 = fPart.split("\\)");
		super.name = source.split(" ")[1];
		super.type = fParts2[0];
		this.argumentName = fParts2[1].trim().split(" = ")[0];
	}

	@Override
	public int evaluate(int[] args) {
		for(int arg:args){
			
		}
		return 0;
	}
}

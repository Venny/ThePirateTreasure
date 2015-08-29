package App;

public class Function extends Argument {
	private String argumentsString;
	private String[] argNames;

	public Function(String source) {
		super(source);

		String fPart = source.split("\\(")[1];
		String[] fParts2 = fPart.split("\\)");
		super.name = source.split(" ")[1];
		super.type = fParts2[0];
		this.argumentsString = fParts2[1].trim().split(" = ")[0];
		this.argNames = argumentsString.split(" ");

	}

	@Override
	public int evaluate(String args) {
		System.out.println("Real arguments: " + args);
		String[] realArgs = args.split(",");
		if (realArgs.length == argNames.length) {
			String newFBody = replaceTheArgs(realArgs);
			System.out.println("New body: " + newFBody);
			return Executable.evaluate(newFBody);
		}	
		System.err.println("The arguments number in function: '" + name + "' is wrong! ");
		System.err.println("arguments number: " + realArgs.length);
		return 0;
	}

	private String replaceTheArgs(String[] realArgs) {
		String[] bodyParts = body.split(" ");
		String newBody = "";
		String temp = "";
		for (int i = 0; i < bodyParts.length; i++) {
			temp = bodyParts[i];
			for (int n = 0; n < argNames.length; n++) {
				if (bodyParts[i].equals(argNames[n])) {
					temp = realArgs[n];
					System.out.println("111111: " + newBody);
				}
				//System.out.println("argNames: " + argNames[n]);
			}
			newBody += temp + " ";
			//System.out.println(newBody);
		}
		return newBody.trim();
	}
}

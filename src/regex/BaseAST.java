package regex;

public class BaseAST implements AST {
	protected FSA compiled;
	
	public FSA getCompiled() {
		return compiled;
	}
}

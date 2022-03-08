package regex.ast;

import regex.fsa.FSA;

public class BaseAST implements AST {
	protected FSA compiled;
	
	public FSA getCompiled() {
		return compiled;
	}
}

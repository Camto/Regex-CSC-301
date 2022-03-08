package regex.ast;

import regex.fsa.FSA;

public interface AST {
	public FSA getCompiled();
}

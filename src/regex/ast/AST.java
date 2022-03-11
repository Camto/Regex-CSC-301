package regex.ast;

import regex.fsa.FSA;

public interface AST {
	public FSA compile();
	public void print(String indent);
}

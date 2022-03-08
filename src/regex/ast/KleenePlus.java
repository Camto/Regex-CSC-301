package regex.ast;

import regex.fsa.*;

public class KleenePlus implements AST {
	public AST node;
	
	public KleenePlus(AST node) {
		this.node = node;
	}
	
	public FSA compile() {
		FSA compiled = node.compile();
		compiled.end.transitions.add(new Transition(compiled.start));
		return compiled;
	}
}

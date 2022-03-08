package regex.ast;

import regex.fsa.*;

public class KleeneStar implements AST {
	public AST node;
	
	public KleeneStar(AST node) {
		this.node = node;
	}
	
	public FSA compile() {
		FSA compiledNode = node.compile();
		compiledNode.end.transitions.add(new Transition(compiledNode.start));
		
		FSA compiled = new FSA(new Transition(compiledNode.start));
		compiledNode.start.transitions.add(new Transition(compiled.end));
		
		return compiled;
	}
}

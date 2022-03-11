package regex.ast;

import regex.fsa.*;

public class Optional implements AST {
	public AST node;
	
	public Optional(AST node) {
		this.node = node;
	}
	
	public FSA compile() {
		FSA compiled = node.compile();
		compiled.start.transitions.add(new Transition(compiled.end));
		return compiled;
	}
	
	public void print(String indent) {
		System.out.println(indent + "Opt");
		node.print(indent + "  ");
	}
}

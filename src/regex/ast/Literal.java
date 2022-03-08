package regex.ast;

import regex.fsa.FSA;

public class Literal implements AST {
	public String lit;
	
	public Literal(String lit) {
		this.lit = lit;
	}
	
	public FSA compile() {
		return new FSA(str -> str.startsWith(lit) ? lit.length() : -1);
	}
}

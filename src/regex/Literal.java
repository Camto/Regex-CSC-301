package regex;

public class Literal implements AST {
	private FSA compiled;
	
	public Literal(String lit) {
		compiled = new FSA(str -> str.startsWith(lit) ? lit.length() : -1);
	}
	
	public FSA getCompiled() {
		return compiled;
	}
}

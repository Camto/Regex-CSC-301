package regex;

public class Literal implements AST {
	private String lit;
	
	public Literal(String lit) {
		this.lit = lit;
	}
	
	public FSA compile() {
		return new FSA(str -> str.startsWith(lit) ? lit.length() : -1);
	}
}

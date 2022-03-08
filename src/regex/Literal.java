package regex;

public class Literal extends BaseAST {
	public Literal(String lit) {
		compiled = new FSA(str -> str.startsWith(lit) ? lit.length() : -1);
	}
}

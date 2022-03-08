package regex;

public class Regex {
	private FSA fsa;
	
	private static class ASTAndRest {
		public AST ast;
		public String rest;
		
		public ASTAndRest(AST ast, String rest) {
			this.ast = ast;
			this.rest = rest;
		}
	}
	
	public Regex(String expr) {
		AST ast = parse(expr).ast;
		fsa = ast.compile();
	}
	
	private static ASTAndRest parse(String expr) {
		if(!expr.contains("|"))
			return new ASTAndRest(new Literal(expr), "");
		else {
			String[] alts = expr.split("\\|");
			return new ASTAndRest(new Alternation(
				new Literal(alts[0]),
				new Literal(alts[1])
			), "");
		}
	}
	
	public boolean doesMatch(String str) {
		return fsa.doesMatch(str);
	}
}

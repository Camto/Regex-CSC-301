package regex;

public class KleenePlus extends BaseAST {
	public KleenePlus(AST node) {
		compiled = node.getCompiled();
		compiled.end.transitions.add(new Transition(compiled.start));
	}
}

package regex;

public class Optional extends BaseAST {
	public Optional(AST node) {
		compiled = node.getCompiled();
		compiled.start.transitions.add(new Transition(compiled.end));
	}
}

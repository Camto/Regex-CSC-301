package regex.ast;

import regex.fsa.FSA;
import regex.fsa.Transition;

public class KleeneStar extends BaseAST {
	public KleeneStar(AST node) {
		FSA compiledNode = node.getCompiled();
		compiledNode.end.transitions.add(new Transition(compiledNode.start));
		
		compiled = new FSA(new Transition(compiledNode.start));
		compiledNode.start.transitions.add(new Transition(compiled.end));
	}
}

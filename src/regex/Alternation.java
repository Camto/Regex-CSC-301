package regex;

import java.util.List;

public class Alternation implements AST {
	private AST left;
	private AST right;
	
	public Alternation(AST left, AST right) {
		this.left = left;
		this.right = right;
	}
	
	public FSA compile() {
		FSA leftCompiled = left.compile();
		FSA rightCompiled = right.compile();
		
		FSA fsa = new FSA();
		fsa.start.transitions.addAll(List.of(
			new Transition(leftCompiled.start),
			new Transition(rightCompiled.start)
		));

		leftCompiled.end.transitions.add(new Transition(fsa.end));
		rightCompiled.end.transitions.add(new Transition(fsa.end));
		
		return fsa;
	}
}

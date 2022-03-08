package regex.ast;

import java.util.Collection;
import java.util.stream.Collectors;

import regex.fsa.FSA;
import regex.fsa.Transition;

public class Alternation extends BaseAST {
	public Alternation(Collection<AST> alternatives) {
		Collection<FSA> compiledAlternatives = alternatives
			.stream()
			.map(alt -> alt.getCompiled())
			.collect(Collectors.toList());
		
		compiled = new FSA();
		compiled.start.transitions.addAll(compiledAlternatives
			.stream()
			.map(comp -> new Transition(comp.start))
			.collect(Collectors.toList())
		);
		
		compiledAlternatives.forEach(comp ->
			comp.end.transitions.add(new Transition(compiled.end))
		);
	}
}

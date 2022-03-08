package regex.ast;

import java.util.Collection;
import java.util.stream.Collectors;

import regex.fsa.*;

public class Alternation implements AST {
	public Collection<AST> alternatives;
	
	public Alternation(Collection<AST> alternatives) {
		this.alternatives = alternatives;
	}
	
	public FSA compile() {
		Collection<FSA> compiledAlternatives = alternatives
			.stream()
			.map(alt -> alt.compile())
			.collect(Collectors.toList());
		
		FSA compiled = new FSA();
		compiled.start.transitions.addAll(compiledAlternatives
			.stream()
			.map(comp -> new Transition(comp.start))
			.collect(Collectors.toList())
		);
		
		compiledAlternatives.forEach(comp ->
			comp.end.transitions.add(new Transition(compiled.end))
		);
		
		return compiled;
	}
}

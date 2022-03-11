package regex.ast;

import java.util.List;
import java.util.stream.Collectors;

import regex.fsa.*;

public class Alternation implements AST {
	public List<AST> alternatives;
	
	public Alternation(List<AST> alternatives) {
		this.alternatives = alternatives;
	}
	
	public FSA compile() {
		if(alternatives.size() == 0) return new FSA(str -> 0);
		if(alternatives.size() == 1) return alternatives.get(0).compile();
		
		List<FSA> compiledAlternatives = alternatives
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
	
	public void print(String indent) {
		System.out.println(indent + "Alt");
		for(AST alternative : alternatives)
			alternative.print(indent + "  ");
	}
}

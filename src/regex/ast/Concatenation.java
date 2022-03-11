package regex.ast;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import regex.fsa.*;

public class Concatenation implements AST {
	public List<AST> nodes;
	
	public Concatenation(List<AST> nodes) {
		this.nodes = nodes;
	}
	
	public FSA compile() {
		if(nodes.size() == 0) return new FSA(str -> 0);
		if(nodes.size() == 1) return nodes.get(0).compile();
		
		List<FSA> compiledNodes = nodes
			.stream()
			.map(alt -> alt.compile())
			.collect(Collectors.toList());
		
		FSA compiled = new FSA(new Transition(compiledNodes.get(0).start));
		compiledNodes.get(compiledNodes.size() - 1).end.transitions
			.add(new Transition(compiled.end));
		
		IntStream.range(0, compiledNodes.size() - 1).forEach(i ->
			compiledNodes.get(i).end.transitions
				.add(new Transition(compiledNodes.get(i + 1).start))
		);
		
		return compiled;
	}
}

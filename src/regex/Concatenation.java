package regex;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concatenation extends BaseAST {
	public Concatenation(Collection<AST> nodes) {
		List<FSA> compiledNodes = nodes
			.stream()
			.map(alt -> alt.getCompiled())
			.collect(Collectors.toList());
		
		compiled = new FSA(new Transition(compiledNodes.get(0).start));
		compiledNodes.get(compiledNodes.size() - 1).end.transitions
			.add(new Transition(compiled.end));
		
		IntStream.range(0, compiledNodes.size() - 1).forEach(i ->
			compiledNodes.get(i).end.transitions
				.add(new Transition(compiledNodes.get(i + 1).start))
		);
	}
}

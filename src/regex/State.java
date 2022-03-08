package regex;

import java.util.function.Function;

public class State {
	public Transition[] transitions;
	
	public State(Transition[] transitions) {
		this.transitions = transitions;
	}
}

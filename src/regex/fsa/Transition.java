package regex.fsa;

import java.util.function.Function;

public class Transition {
	private Function<String, Integer> condition;
	public State next;
	
	public Transition(Function<String, Integer> condition, State next) {
		this.condition = condition;
		this.next = next;
	}
	
	public Transition(State next) {
		this.next = next;
		condition = str -> 0;
	}
	
	public int apply(String str) {
		return condition.apply(str);
	}
}

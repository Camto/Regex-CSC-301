package regex;

import java.util.function.Function;

public class FSA {
	private State start;
	private State end;
	
	public FSA(Function<String, Integer> transition) {
		end = new State(new Transition[] {});
		start = new State(new Transition[] {new Transition(transition, end)});
	}
	
	public boolean doesMatch(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(doesMatch(str.substring(i), start))
				return true;
		}
		return false;
	}
	
	public boolean doesMatch(String str, State state) {
		for(Transition transition : state.transitions) {
			if(transition.apply(str) != -1 && transition.next == end)
				return true;
		}
		return false;
	}
}

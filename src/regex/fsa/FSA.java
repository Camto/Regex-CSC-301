package regex.fsa;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

public class FSA {
	public State start;
	public State end;
	
	public FSA() {
		start = new State();
		end = new State();
	}
	
	public FSA(Transition transition) {
		start = new State(new ArrayList<>(List.of(transition)));
		end = new State();
	}
	
	public FSA(Function<String, Integer> transition) {
		end = new State();
		start = new State(new ArrayList<>(List.of(new Transition(transition, end))));
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
			// System.out.println(str);
			// System.out.println(transition);
			int res = transition.apply(str);
			if(res == -1) continue;
			if(transition.next == end) return true;
			if(doesMatch(str.substring(res), transition.next)) return true;
		}
		return false;
	}
	
	public boolean doesMatchExactly(String str) {
		return doesMatchExactly(str, start);
	}
	
	public boolean doesMatchExactly(String str, State state) {
		for(Transition transition : state.transitions) {
			int res = transition.apply(str);
			if(res == -1) continue;
			if(transition.next == end && str.length() == res) return true;
			if(doesMatchExactly(str.substring(res), transition.next)) return true;
		}
		return false;
	}
}

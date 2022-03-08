package regex.fsa;

import java.util.ArrayList;

public class State {
	public ArrayList<Transition> transitions;
	
	public State() {
		transitions = new ArrayList<>();
	}
	
	public State(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}
}

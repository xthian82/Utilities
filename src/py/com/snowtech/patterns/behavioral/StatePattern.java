package py.com.snowtech.patterns.behavioral;

/**
 * In State pattern a class behavior changes based on its state. 
 * This type of design pattern comes under behavior pattern. 
 * 
 * In State pattern, we create objects which represent various states 
 * and a context object whose behavior varies as its state object changes.
 * 
 * IMPLEMENTATION
 * ==============
 * We are going to create a State interface defining an action and concrete 
 * state classes implementing the State interface. Context is a class which carries a State.
 * 
 * StatePattern, our demo class, will use Context and state objects to demonstrate 
 * change in Context behavior based on type of state it is in.
 * 
 * @author cristhian
 *
 */

interface State {
	public void doAction(Context context);
}

class Context {
	private State state;

	public Context() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}

class StartState implements State {

	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString() {
		return "Start State";
	}
}

class StopState implements State {

	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}

	public String toString() {
		return "Stop State";
	}
}

public class StatePattern {
	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}

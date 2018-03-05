package py.com.snowtech.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento pattern is used to reduce where we want to restore state of an object 
 * to a previous state. Memento pattern falls under behavioral pattern category.
 * 
 * Memento pattern uses three actor classes. Memento contains state of an object 
 * to be restored. Originator creates and stores states in Memento objects and 
 * Caretaker object which is responsible to restore object state from Memento.
 * 
 * We've created classes Memento, Originator and CareTaker.
 * MementoPatternDemo, our demo class will use CareTaker and Originator objects 
 * to show restoration of object states.
 * 
 * @author cristhian
 *
 */

class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}

class Originator {
	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState();
	}
}

class CareTaker {
	private List<Memento> mementoList = new ArrayList<>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}

public class MementoPattern {
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());
		
		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(0));
		
		System.out.println("First saved State: " + originator.getState());
		
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());
	}
}

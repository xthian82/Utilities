package py.com.snowtech.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Observer pattern is used when there is one to 
 * many relationship between objects such as if 
 * one object is modified, its depenedent objects are 
 * to be notified automatically. Observer pattern falls under behavioral pattern category.
 * 
 * @author cristhian
 *
 */

class Sentence {
	private List<Observer> observers = new ArrayList<Observer>();
	private String state;
	private int index;
	private int length;

	public Sentence(String str) {
		this.state = str;
		this.index = -1;
		this.length = str.length();
	}
	
	public Character getItem() {
		if (index >= 0 && index < this.length)
			return state.charAt(index);
		else
			return null;
	}

	public boolean readCharacter() {
		if (this.index < this.length ) {
			this.index++;
			notifyAllObservers();
			return true;
		} else {
			return false;
		}
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}

abstract class Observer {
	protected Sentence sentence;
	public abstract void update();
	public abstract boolean isValid();
}

class ClosedCharacters extends Observer{
	private Stack<Character> cmd = new Stack<Character>();
	private static final Character openTAGS[] = {'[','{','('};
	private static final Character closedTAGS[] = {']','}',')'};
	
	public ClosedCharacters(Sentence sentece) {
		this.sentence = sentece;
		this.sentence.attach(this);
	}

	@Override
	public void update() {
		Character item = this.sentence.getItem();
		// if it is an open tag, we just push it into the stack
		if (contains(openTAGS, item) > -1) {
			cmd.push(item);
		} else {
			int pos = contains(closedTAGS, item);
			if (pos > - 1) {
				//it's a close tag, check if it's open tag is at top
				if (cmd.peek() == openTAGS[pos])
					cmd.pop();
			}
		}
	}
	
	public boolean isValid() {
		return cmd.isEmpty();
	}
	
	private int contains(Character[] list, Character c) {
		int index = 0;
		for (Character charc : list) {
			if (charc == c) return index;
			index++;
		}
		
		return -1;
	}
}

class Counter extends Observer {
	private int aCounter;
	
	public Counter(Sentence sentence) {
		this.sentence = sentence;
		this.sentence.attach(this);
	}

	@Override
	public void update() {
		Character item = this.sentence.getItem();
		if (item != null && (item == 'A' || item == 'a')) {
			this.aCounter++;
		}
	}
	
	public boolean isValid() {
		return this.aCounter == 7;
	}
}

public class ObserverSubject {
	public static void main(String[] args) {
		Sentence subject = new Sentence("zdvvd [({gewaaage})]{aaaa");

		ClosedCharacters cc = new ClosedCharacters(subject);
	    Counter co = new Counter(subject);

	    while (subject.readCharacter());
	    
	    System.out.println("Word is closed : " + cc.isValid());
	    System.out.println("Word has 7As : " + co.isValid());
	}
}

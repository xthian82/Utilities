package py.com.snowtech.patterns.behavioral;

import java.util.Date;

/**
 * Mediator pattern is used to reduce communication complexity between 
 * multiple objects or classes. This pattern provides a mediator class 
 * which normally handles all the communications between different classes 
 * and supports easy maintainability of the code by loose coupling. Mediator 
 * pattern falls under behavioral pattern category.
 * 
 * IMPLEMENTATION
 * ==============
 * We're demonstrating mediator pattern by example of a Chat Room where 
 * multiple users can send message to Chat Room and it is the responsibility 
 * of Chat Room to show the messages to all users. We've created two classes 
 * ChatRoom and User. User objects will use ChatRoom method to share their messages.
 * 
 * Mediator, our demo class will use User objects to show communication between them.
 * 
 * @author cristhian
 *
 */

class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}

class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
	}
}

public class Mediator {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");
		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}

}

package py.com.snowtech.patterns.behavioral;

/**
 * Command pattern is a data driven design pattern and falls under behavioral 
 * pattern category. A request is wrapped under an object as command and passed 
 * to invoker object. Invoker object looks for the appropriate object which can 
 * handle this command and passes the command to the corresponding object which 
 * executes the command.
 * 
 */

import java.util.ArrayList;
import java.util.List;

interface commandInterface {
	void execute();
}

class FlipUpCommand implements commandInterface {
	private Light light;
	
	public FlipUpCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.turnOn();
	}
}

class FlipDownCommand implements commandInterface {
	private Light light;
	
	public FlipDownCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		this.light.turnOff();
	}
}

public class Command {
	public static void main(String[] args) {
		 Light lamp = new Light();
	     commandInterface switchUp = new FlipUpCommand(lamp);
	     commandInterface switchDown = new FlipDownCommand(lamp);
	 
	     Switch mySwitch = new Switch();
	     
	     switch(Integer.parseInt(args[0])) {
         case 0:
            mySwitch.storeAndExecute(switchUp);
            break;
         case 1:
            mySwitch.storeAndExecute(switchDown);
            break;
         default:
            System.out.println("Argument \"ON\" or \"OFF\" is required.");
       }
	}
}

class Light {
	public void turnOn() {
		System.out.println("The light is on");
	}
	
	public void turnOff() {
		System.out.println("The light is off");
	}
}

class Switch {
	private List<commandInterface> history = new ArrayList<commandInterface>();
	
	public void storeAndExecute(commandInterface cmd) {
		this.history.add(cmd);
		cmd.execute();
	}
}


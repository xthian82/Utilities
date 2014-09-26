package py.com.snowtch.patterns;

import java.util.ArrayList;
import java.util.List;

interface Command {
	void execute();
}

class FlipUpCommand implements Command {
	private Light light;
	
	public FlipUpCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.turnOn();
	}
}

class FlipDownCommand implements Command {
	private Light light;
	
	public FlipDownCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		this.light.turnOff();
	}
}

public class CommandPattern {
	public static void main(String[] args) {
		 Light lamp = new Light();
	     Command switchUp = new FlipUpCommand(lamp);
	     Command switchDown = new FlipDownCommand(lamp);
	 
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
	private List<Command> history = new ArrayList<Command>();
	
	public void storeAndExecute(Command cmd) {
		this.history.add(cmd);
		cmd.execute();
	}
}


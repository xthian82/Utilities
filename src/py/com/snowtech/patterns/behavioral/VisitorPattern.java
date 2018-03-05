package py.com.snowtech.patterns.behavioral;

/**
 * In Visitor pattern, we use a visitor class which changes 
 * the executing algorithm of an element class. By this way, 
 * execution algorithm of element can vary as and when visitor 
 * varies. This pattern comes under behavior pattern category. 
 * 
 * As per the pattern, element object has to accept the visitor 
 * object so that visitor object handles the operation on the 
 * element object.
 * 
 * IMPLEMENTATION
 * ==============
 * We are going to create a ComputerPart interface defining accept 
 * opearation.Keyboard, Mouse, Monitor and Computer are concrete 
 * classes implementing ComputerPart interface. We will define another 
 * interface ComputerPartVisitor which will define a visitor class operations. 
 * Computer uses concrete visitor to do corresponding action.
 * 
 * VisitorPattern, our demo class, will use Computer and ComputerPartVisitor 
 * classes to demonstrate use of visitor pattern.
 * 
 * @author cristhian
 *
 */

interface ComputerPart {
	void accept(ComputerPartVisitor computerPartVisitor);
}

interface ComputerPartVisitor {
	void visit(Computer computer);
	void visit(Mouse mouse);
	void visit(Keyboard keyboard);
	void visit(Monitor monitor);
}

class Keyboard implements ComputerPart {
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Monitor implements ComputerPart {
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Mouse implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Computer implements ComputerPart {

	ComputerPart[] parts;

	public Computer() {
		parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor.");
	}
}

public class VisitorPattern {
	public static void main(String[] args) {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}

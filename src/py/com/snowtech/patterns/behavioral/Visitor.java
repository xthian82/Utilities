package py.com.snowtech.patterns.behavioral;


interface ICarElement {
    void accept(ICarElementVisitor visitor);
}

interface ICarElementVisitor {
	void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Car car);
    void visit(Body body);
}

class Car implements ICarElement {
	public ICarElement[] elements;

	public Car() {
		this.elements = new ICarElement[] {
			new Wheel("right"), new Wheel("left"), new Wheel("front"),
			new Wheel("back"), new Engine(), new Body()
		};
	}
	
	@Override
	public void accept(ICarElementVisitor visitor) {
		for (ICarElement elem : elements) {
			elem.accept(visitor);
		}
		
		visitor.visit(this);
	}
}

class Body implements ICarElement {

	@Override
	public void accept(ICarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Engine implements ICarElement {
	public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}


class Wheel implements ICarElement {
	private String name;
	 
    public Wheel(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void accept(ICarElementVisitor visitor) {
        /*
         * accept(ICarElementVisitor) in Wheel implements
         * accept(ICarElementVisitor) in ICarElement, so the call
         * to accept is bound at run time. This can be considered
         * the first dispatch. However, the decision to call
         * visit(Wheel) (as opposed to visit(Engine) etc.) can be
         * made during compile time since 'this' is known at compile
         * time to be a Wheel. Moreover, each implementation of
         * ICarElementVisitor implements the visit(Wheel), which is
         * another decision that is made at run time. This can be
         * considered the second dispatch.
         */
        visitor.visit(this);
    }
}

class CarElementPrintVisitor implements ICarElementVisitor {
    public void visit(Wheel wheel) {      
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
 
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
 
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
 
    public void visit(Car car) {      
        System.out.println("Visiting car");
    }
}

class CarElementDoVisitor implements ICarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }
 
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
 
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
 
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
}

public class Visitor {
	public static void main(String[] args) {
		ICarElement car = new Car();
	
		car.accept(new CarElementPrintVisitor());
		car.accept(new CarElementDoVisitor());
	}
}

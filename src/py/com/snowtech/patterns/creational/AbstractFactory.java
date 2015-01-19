package py.com.snowtech.patterns.creational;

/**
 * Creational Design Pattern
 * 
 * Abstract Factory patterns works around a super-factory which creates other
 * factories. This factory is also called as Factory of factories.
 * 
 * This pattern provides one of the best ways to create an object. An interface
 * is responsible for creating a factory of related objects, without explicitly
 * specifying their classes. Each generated factory can give the objects as per
 * the Factory pattern.
 * 
 * @author cristhian
 * 
 */

interface IColor {
	void fill();
}

// ------------------------------
// CONCRETE CLASSES
// ------------------------------
class Red implements IColor {
	@Override
	public void fill() {
		System.out.println("fill red color");
	}
}

class Green implements IColor {
	@Override
	public void fill() {
		System.out.println("fill green color");
	}
}

class Blue implements IColor {
	@Override
	public void fill() {
		System.out.println("fill blue color");
	}
}

abstract class AbstractFactoryClass {
	abstract IColor getColor(String color);

	abstract IShape getShape(String shape);
}

class ColorFactory extends AbstractFactoryClass {
	@Override
	IColor getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}

	IShape getShape(String shape) {
		return null;
	}
}

class ShapeAbsFactory extends AbstractFactoryClass {
	public IShape getShape(String shapeType) {
		if (shapeType == null)
			return null;

		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

	@Override
	IColor getColor(String color) {
		return null;
	}
}

class FactoryProducer {
	public static AbstractFactoryClass getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeAbsFactory();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}

public class AbstractFactory {
	public static void main(String[] args) {
	     //get shape factory
	      AbstractFactoryClass shapeFactory = FactoryProducer.getFactory("SHAPE");
	     
	      //get an object of Shape Circle
	      IShape shape1 = shapeFactory.getShape("CIRCLE"); //call draw method of Shape Circle
	      shape1.draw();
	      
	      //get an object of Shape Rectangle
	      IShape shape2 = shapeFactory.getShape("RECTANGLE");
	      //call draw method of Shape Rectangle
	      shape2.draw();
	      
	      //get an object of Shape Square
	      IShape shape3 = shapeFactory.getShape("SQUARE"); //call draw method of Shape Square
	      shape3.draw();
	      
	      //get color factory
	      AbstractFactoryClass colorFactory = FactoryProducer.getFactory("COLOR");
	      
	      //get an object of Color Red
	      IColor color1 = colorFactory.getColor("RED"); //call fill method of Red
	      color1.fill();
	      
	      //get an object of Color Green
	      IColor color2 = colorFactory.getColor("Green"); //call fill method of Green
	      color2.fill();
	      
	      //get an object of Color Blue
	      IColor color3 = colorFactory.getColor("BLUE");
	      
	      //call fill method of Color Blue
	      color3.fill();
	}
}
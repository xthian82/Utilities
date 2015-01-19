package py.com.snowtech.patterns.creational;

/**
 * Creational Design Pattern
 * 
 * In Factory pattern, we create object without exposing the creation logic to
 * the client and refer to newly created object using a common interface.
 * 
 * @author cristhian
 * 
 */
interface IShape {
	void draw();
}

// ------------------------------
// CONCRETE CLASSES
// ------------------------------
class Rectangle implements IShape {

	@Override
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
}

class Circle implements IShape {
	@Override
	public void draw() {
		System.out.println("Drawing a circle");
	}

}

class Square implements IShape {
	@Override
	public void draw() {
		System.out.println("Drawing a square");
	}
}

// ---------------------------------------
// Factory class, use to get a shape type
// ---------------------------------------
class ShapeFactory {
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
}

//how to use
public class Factory {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		// get an object of Circle and call its draw method.
		IShape shape1 = shapeFactory.getShape("CIRCLE"); // call draw method of
														// Circle
		shape1.draw();
		// get an object of Rectangle and call its draw method.
		IShape shape2 = shapeFactory.getShape("RECTANGLE");
		// call draw method of Rectangle
		shape2.draw();
		// get an object of Square and call its draw method.
		IShape shape3 = shapeFactory.getShape("SQUARE");
		// call draw method of circle
		shape3.draw();
	}
}
package py.com.snowtech.patterns;

import java.util.Hashtable;

/**
 * PROTOTYPE 
 * ---------
 * 
 * Prototype pattern refers to creating duplicate object while keeping
 * performance in mind. This type of design pattern comes under creational
 * pattern as this pattern provides one of the best ways to create an object.
 * 
 * This pattern involves implementing a prototype interface which tells to
 * create a clone of the current object.
 * 
 * This pattern is used when creation of object directly is costly. For example,
 * an object is to be created after a costly database operation. We can cache
 * the object, returns its clone on next request and update the database as and
 * when needed thus reducing database calls
 * 
 * IMPLEMENTATION 
 * ============== 
 * 
 * We're going to create an abstract class Shape
 * and concrete classes extending the Shape class. A class ShapeCache is defined
 * as a next step which stores shape objects in a Hashtable and returns their
 * clone when requested.
 * 
 * Prototype, our demo class will use ShapeCache class to get a Shape object.
 * 
 * @author xpy0035
 *
 */

// Create an abstract class implementing Clonable interface.
abstract class AShape implements Cloneable {

	private String id;
	protected String type;

	abstract void draw();

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}
}

// Create concrete classes extending the above class.
class BodyRectangle extends AShape {

	public BodyRectangle() {
		type = "BodyRectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside BodyRectangle::draw() method.");
	}
}

class BodySquare extends AShape {

	public BodySquare() {
		type = "BodySquare";
	}

	@Override
	public void draw() {
		System.out.println("Inside BodySquare::draw() method.");
	}
}

class BodyCircle extends AShape {

	public BodyCircle() {
		type = "BodyCircle";
	}

	@Override
	public void draw() {
		System.out.println("Inside BodyCircle::draw() method.");
	}
}

// Create a class to get concrete classes from database and store them in a
// Hashtable
class ShapeCache {

	private static Hashtable<String, AShape> shapeMap = new Hashtable<String, AShape>();

	public static AShape getShape(String shapeId) {
		AShape cachedShape = shapeMap.get(shapeId);
		return (AShape) cachedShape.clone();
	}

	// for each shape run database query and create shape
	// shapeMap.put(shapeKey, shape);
	// for example, we are adding three shapes

	public static void loadCache() {
		BodyCircle circle = new BodyCircle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		BodySquare square = new BodySquare();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		BodyRectangle rectangle = new BodyRectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}

public class Prototype {
	public static void main(String[] args) {
		ShapeCache.loadCache();

		AShape clonedShape = (AShape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());

		AShape clonedShape2 = (AShape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());

		AShape clonedShape3 = (AShape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
	}
}

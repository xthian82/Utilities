package py.com.snowtech.patterns.structural;

/**
 * Bridge is used when we need to decouple an abstraction from its implementation so that 
 * the two can vary independently. This type of design pattern comes under structural pattern 
 * as this pattern decouples implementation class and abstract class by providing a bridge 
 * structure between them.
 * 
 * This pattern involves an interface which acts as a bridge which makes the functionality 
 * of concrete classes independent from interface implementer classes. Both types of classes 
 * can be altered structurally without affecting each other.
 * 
 * We are demonstrating use of Bridge pattern via following example in which a circle can be 
 * drawn in different colors using same abstract class method but different bridge 
 * implementer classes.
 * 
 * @author cristhian
 *
 */
interface DrawingAPI {
	void drawCircle(double x, double y, double r);
}

/** "ConcreteImplementor"  1/2 */
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
    }
}
 
/** "ConcreteImplementor" 2/2 */
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}
 
/** "Abstraction" */
abstract class Shape {
    protected DrawingAPI drawingAPI;
 
    protected Shape(DrawingAPI drawingAPI){
        this.drawingAPI = drawingAPI;
    }
 
    public abstract void draw();                             // low-level
    public abstract void resizeByPercentage(double pct);     // high-level
}

/** "Refined Abstraction" */
class CircleShape extends Shape {
    private double x, y, radius;
    
    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;  
        this.y = y;  
        this.radius = radius;
    }
 
    // low-level i.e. Implementation specific
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
    
    // high-level i.e. Abstraction specific
    public void resizeByPercentage(double pct) {
        radius *= pct;
    }
}

public class Bridge {
	public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
            new CircleShape(1, 2, 3, new DrawingAPI1()),
            new CircleShape(5, 7, 11, new DrawingAPI2()),
        };
 
        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}

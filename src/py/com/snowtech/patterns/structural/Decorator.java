package py.com.snowtech.patterns.structural;

/**
 * Decorator pattern allows a user to add new functionality to an existing object 
 * without altering its structure. This type of design pattern comes under structural 
 * pattern as this pattern acts as a wrapper to existing class.
 * 
 * This pattern creates a decorator class which wraps the original class and provides 
 * additional functionality keeping class methods signature intact.
 * 
 * We are demonstrating the use of decorator pattern via following example in which we 
 * will decorate a shape with some color without alter shape class.
 * 
 * IMPLEMENTATION
 * ==============
 * 
 * We're going to create a Shape interface and concrete classes implementing the Shape 
 * interface. We will then create an abstract decorator class ShapeDecorator implementing 
 * the Shape interface and having Shape object as its instance variable. RedShapeDecorator 
 * is concrete class implementing ShapeDecorator.
 * 
 * Decorator, our demo class will use RedShapeDecorator to decorate Shape objects.
 * 
 * @author cristhian
 *
 */
interface DShape {
	void draw();
}

class Rectangle implements DShape {

   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}

class Circle implements DShape {

   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}

abstract class ShapeDecorator implements DShape {
   protected DShape decoratedShape;

   public ShapeDecorator(DShape decoratedShape){
      this.decoratedShape = decoratedShape;
   }

   public void draw(){
      decoratedShape.draw();
   }	
}

class RedShapeDecorator extends ShapeDecorator {

	   public RedShapeDecorator(DShape decoratedShape) {
	      super(decoratedShape);		
	   }

	   @Override
	   public void draw() {
	      decoratedShape.draw();	       
	      setRedBorder(decoratedShape);
	   }

	   private void setRedBorder(DShape decoratedShape){
	      System.out.println("Border Color: Red");
	   }
	}

public class Decorator {
	public static void main(String[] args) {

		DShape circle = new Circle();

		DShape redCircle = new RedShapeDecorator(new Circle());

		DShape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}

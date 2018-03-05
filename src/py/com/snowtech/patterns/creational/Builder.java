package py.com.snowtech.patterns.creational;

import java.util.ArrayList;
import java.util.List;

/**
 * BUILDER PATTERN
 * ---------------
 * 
 * Builder pattern builds a complex object using simple objects and using a step
 * by step approach. This type of design pattern comes under creational pattern
 * as this pattern provides one of the best ways to create an object.
 * 
 * A Builder class builds the final object step by step. This builder is
 * independent of other objects.
 *
 * Implementation
 * ==============
 * We have considered a business case of fast-food restaurant where a typical meal could be a burger 
 * and a cold drink. Burger could be either a Veg Burger or Chicken Burger and will be packed by a wrapper. 
 * 
 * Cold drink could be either a coke or pepsi and will be packed in a bottle.
 * 
 * We are going to create an Item interface representing food items such as burgers and cold drinks and 
 * concrete classes implementing the Item interface and a Packing interface representing packaging of food 
 * items and concrete classes implementing the Packing interface as burger would be packed in wrapper and 
 * cold drink would be packed as bottle. 
 * 
 * We then create a Meal class having ArrayList of Item and a MealBuilder to build different types of Meal 
 * objects by combining Item. 
 * 
 * Builder, our demo class will use MealBuilder to build a Meal.
 * 
 * @author xpy0035
 *
 */

//-------------------------------------------------------------
// Create an interface Item representing food item and packing
//-------------------------------------------------------------
interface Item {
	String name();

	Packing packing();

	float price();
}

interface Packing {
	String pack();
}

// -------------------------------------------------------------
// Create concrete classes implementing the Packing interface.
//--------------------------------------------------------------
class Bottle implements Packing {
	@Override
	public String pack() {
		return "Bottle";
	}
}

class Wrapper implements Packing {
	@Override
	public String pack() {
		return "Wrapper";
	}
}

//-------------------------------------------------------------
// Create abstract classes implementing the item interface 
// providing default functionalities.
//-------------------------------------------------------------
abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}

abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}

//-------------------------------------------------------------
// Create concrete classes extending Burger and ColdDrink classes
//-------------------------------------------------------------
class VegBurger extends Burger {

	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}
}

class ChickenBurger extends Burger {

	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}

class Coke extends ColdDrink {

	@Override
	public float price() {
		return 30.0f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}

class Pepsi extends ColdDrink {

	@Override
	public float price() {
		return 35.0f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}

// Create a Meal class having Item objects defined above
class Meal {
	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;

		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}

	public void showItems() {

		for (Item item : items) {
			System.out.print("Item : " + item.name());
			System.out.print(", Packing : " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}
	}
}

// Create a MealBuilder class, the actual builder class responsible to create Meal objects
class MealBuilder {
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}

public class Builder {
	public static void main(String[] args) {

		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost: " + vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-Veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
}

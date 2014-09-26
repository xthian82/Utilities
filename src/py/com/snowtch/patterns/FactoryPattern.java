package py.com.snowtch.patterns;

interface CarInterface {
	String getType();
}

interface CarFactory {
	CarInterface makeCar();
}

public class FactoryPattern implements CarFactory {
	@Override
	public CarInterface makeCar() {
		return new Sedan();
	}
}

class Sedan implements CarInterface {
	private int year = 1;
	private String color = null;
	
	public Sedan() {
		this.year = 1984;
		this.color = "red";
	}

	@Override
	public String getType() {
		return "Sedan";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
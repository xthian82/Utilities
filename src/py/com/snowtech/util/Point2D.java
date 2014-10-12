package py.com.snowtech.util;

import java.util.Comparator;

public class Point2D {
	private double x;
	private double y;
	
	public static Comparator<Point2D> Y_ORDER = new Comparator<Point2D>() {		
		public int compare(Point2D o1, Point2D o2) {
			if (o1.y < o2.y) return -1;
			if (o1.y > o2.y) return 1;
			
			return 0;
		}
	};	
	
	public Comparator<Point2D> BY_POLAR_ORDER = new Comparator<Point2D>() {
		public int compare(Point2D p1, Point2D p2) {
			double th1 = Math.atan2(p1.y, p1.x);
			double th2 = Math.atan2(p2.y, p2.x);
			
			if (th1 < th2) return -1;
			if (th1 > th2) return 1;
			
			return 0;
		}
		
	};
	
	public Point2D() {
		super();
	}

	public Point2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public static int counterClockWise(Point2D a, Point2D b, Point2D c) {
		double area = (b.getX()-a.getX())*(c.getY()-a.getY())-(b.getY()-a.getY())*(c.getX()-a.getX());
		
		if (area < 0) return -1;
		if (area > 0) return 1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

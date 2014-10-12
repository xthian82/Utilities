package py.com.snowtech.util;

import java.util.Arrays;
import java.util.Iterator;

import py.com.snowtech.datastructure.Pila;

public class ConvexHull {
	public static Pila<Point2D> process(Point2D[] p) {
		Pila<Point2D> hull = new Pila<Point2D>();
		int N = p.length;
		
		Arrays.sort(p, Point2D.Y_ORDER);
		Arrays.sort(p, p[0].BY_POLAR_ORDER);
		
		hull.push(p[0]);
		hull.push(p[1]);
		
		for (int i=2; i<N; i++) {
			Point2D top = hull.pop();
			
			while (Point2D.counterClockWise(top, p[i], hull.peek()) <= 0) {
				if (hull.size() > 1) top = hull.pop();
				else break;
			}
			
			hull.push(top);
			hull.push(p[i]);
		}
		
		return hull;
	}
	
	public static void main(String... string) {
		Point2D[] p = { new Point2D(-3,2), 
				        new Point2D(-2,3),
				        new Point2D(-1,3),
				        new Point2D(-1,2),
				        new Point2D(-2,0),
				        new Point2D(-1,-1),
				        new Point2D(0,2),
				        new Point2D(1,3),
				        new Point2D(1,4),
				        new Point2D(3,3),
				        new Point2D(3,1),
				        new Point2D(1,0),
		              };
		
		Pila<Point2D> s = ConvexHull.process(p);
		Iterator<Point2D> it = s.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

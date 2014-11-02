package py.com.snowtech.patterns;

public class Singleton {
	private static Singleton a = null;
	
	private Singleton() { }
	
	public static Singleton getInstante() {
		synchronized (a) {
			if (a == null) {
				a = new Singleton();
			}
		}
		return a;
	}
}

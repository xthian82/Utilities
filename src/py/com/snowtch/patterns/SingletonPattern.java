package py.com.snowtch.patterns;

public class SingletonPattern {
	private static SingletonPattern a = null;
	
	private SingletonPattern() { }
	
	public static SingletonPattern getInstante() {
		synchronized (a) {
			if (a == null) {
				a = new SingletonPattern();
			}
		}
		return a;
	}
}

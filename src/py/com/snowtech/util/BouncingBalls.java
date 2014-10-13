package py.com.snowtech.util;

public class BouncingBalls {
	public static void main(String... args) {
		int N = Integer.parseInt(args[0]);
		Ball[] balls = new Ball[N];
		for (int i=0; i<N; i++) {
			balls[i] = new Ball();
		}
		
		while (true) {
			//StdDraw.clear();
			for (int i=0; i<N; i++) {
				balls[i].move(5);
				balls[i].draw();
			}
			//StdDraw.show(50);
		}
	}
}

class Ball {
	private double rx, ry;
	private double vx, vy;
	private final double radius;
	
	public Ball() {
		this.rx = 1024*(Math.random())%1024  + 1;
		this.ry = 768*(Math.random())%768  + 1;
		this.vx = 4;
		this.vy = 3;
		this.radius = 5.0;
	}
	
	public void move(double dt) {
		if ((rx + vx*dt < radius) || (rx + vx*dt > 1 - radius)) { vx = -vx; }
		if ((ry + vy*dt < radius) || (ry + vy*dt > 1 - radius)) { vy = -vy; }
		rx = rx + vx*dt;
		ry = ry + vy*dt;
	}
	public void draw() {
		//StdDraw.filledCircle(rx, ry, radius);
	}
}
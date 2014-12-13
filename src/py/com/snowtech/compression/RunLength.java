package py.com.snowtech.compression;

public class RunLength {
	private final static int R = 255;
	private BinaryStdIn stdin;
	private BinaryStdOut stdout;

	public void compress() {
		char cnt = 0;
		boolean b, old = false;
		while (!stdin.isEmpty()) {
			b = stdin.readBoolean();
			if (b != old) {
				stdout.write(cnt);
				cnt = 0;
				old = !old;
			} 
			else {
				if (cnt == R) {
					stdout.write(cnt);
					cnt = 0;
					stdout.write(cnt);
				} 
			}
			cnt++; 
		}
		stdout.write(cnt);
		stdout.close();
	}

	public void expand() {
		boolean bit = false;

		while (!stdin.isEmpty()) {
			char run = stdin.readChar();
			for (int i=0; i < run; i++)
				stdout.write(bit);
			bit = !bit;
		}
		stdout.close();
	}
}

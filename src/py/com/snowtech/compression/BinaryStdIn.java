package py.com.snowtech.compression;

/**
 * The purpose is to read and write bits, where StdIn and StdOut are oriented toward character 
 * streams encoded in Unicode. An int value on StdOut is a sequence of characters 
 * (its decimal representation); an int value on BinaryStdOut is a sequence of bits 
 * (its binary representation).
 * 
 * 
 * @author cristhian
 *
 */

public class BinaryStdIn {
	public boolean readBoolean() {
		return false;
	}
	
	public char readChar() {
		return 0;
	}
	
	public char readChar(int i) {
		return 0;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public void close() {
		
	}

	public int readInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}

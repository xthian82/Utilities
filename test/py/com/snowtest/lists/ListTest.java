package py.com.snowtest.lists;

import static org.junit.Assert.*;

import org.junit.Test;

import py.com.snowtech.datastructure.lists.Lista;

public class ListTest {

	@Test
	public void test() {
		Lista<Integer> ap = new Lista<Integer>();
		
		assertArrayEquals(new Integer[] {} , ap.toArray());
		ap.add(1);
		ap.add(5);
		ap.add(9);
		ap.add(19);
		
		assertArrayEquals(new Integer[] {1, 5, 9, 19} , ap.toArray());
	}

}

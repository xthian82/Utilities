package py.com.coursera.digraphy.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.Digrafo;
import py.com.snowtech.datastructure.graphs.KosarajuSharirSC;

/*
    A:  G 
    B:  A 
    C:  D I B 
    D:  I 
    E:  J D 
    F:  A 
    G:  B F H 
    H:  I C B 
    I:  J 
    J:  D
 * */
public class Digraph3 {
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("dgraph3.txt"));
		String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
		g.letterPrint();
		KosarajuSharirSC sc = new KosarajuSharirSC(g);
		for (int v = 0; v < sc.getVertexs(); v++) 
			System.out.print(letters[v] + " ");
		System.out.println( );
		for (int v = 0; v < sc.getVertexs(); v++)
			System.out.print(sc.id(v) + " ");
	}
}

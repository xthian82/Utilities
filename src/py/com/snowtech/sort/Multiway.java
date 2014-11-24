package py.com.snowtech.sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import py.com.snowtech.datastructure.IndexMinPQ;

public class Multiway {
	public static void merge(InputStreamReader[] streams)
	{
		int N = streams.length;
		String str = null;
		BufferedReader[] br = new BufferedReader[N];
		for (int i=0; i<N; i++)
			br[i] = new BufferedReader(streams[i]);
		
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);

		for (int i = 0; i < N; i++) {
			try {
				str = br[i].readLine();
				if (str != null)
					pq.insert(i, str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int i = 0;
		while (!pq.isEmpty())
		{
			System.out.print(pq.min() + " ");
			i = pq.delMin();
			//System.out.println(" -i-" + i);
			try {
				str = br[i].readLine();
				if (str != null)
					pq.insert(i, str.trim());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
	}
	
	private static String getNextString(InputStreamReader r) {
		
		String s = "";
		int c;
		
		try {
			while ( (c = r.read()) > 0 ) {
				
				char cc = (char)c;
				if (isBlank(cc)) {
					break;
				}
				s += cc;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (s.length() == 0) return null;	
		return s;
	}

	private static boolean isBlank(char cc) {
	
		return (cc == ' ' || cc == '\n' || cc == '\t' || cc == '\r');
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		int N = args.length;
		FileReader[] streams = new FileReader[N];

		for (int i = 0; i < N; i++)
			streams[i] = new FileReader(args[i]);

		merge(streams);
	}
}

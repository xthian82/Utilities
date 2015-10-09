package py.com.snowtech.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TriangleMatches {
	private int height;
	private int length;
	private int treeLength; 
	private int totalPaths;
	private int[] vec;
	private int total = 0;
	private double maxSum;
	private Map<Integer, ArrayList<Integer>> list;
	
	public TriangleMatches(int height) {
		this.height = height;
		list = new HashMap<Integer, ArrayList<Integer>>();
		length = 0;
		//TODO: improove
		for (int i = 1; i<=height; i++)
		{
			length += i;
		}

	    treeLength = (int)Math.pow(2, height)-1;
	    totalPaths = (int) Math.pow(2, height-1);

		vec = new int[treeLength];
		createGraphParents();
	}
	
	public void createGraphParents() {
		int p = 1, k=0;
		for (int i = 0; i<height; i++) 
		{
			for (int j=0; j<=i; j++)
			{
				ArrayList<Integer> sons = new ArrayList<Integer>();
				sons.add(p); 
				p++;
				 sons.add(p);
				list.put(k, sons);
				
				k++;
			}
			p++;
			if (p >= length-1) break;
		}
	}
	
	public void iterate(int[] c, int pos, int n)
	{
		if (pos >= length) 
		{
			double l = createGraphByArray(c);
			
			if (  l == maxSum )
			{
				++total;
				//print(c);
				//System.out.println(": " + l);
			}
			
			return;
		}
		
		for (int j=1; j<=n; j++) {
			c[pos] = j;
			iterate(c, pos+1, n);
		}
	}
	
	private int allPaths(int[] v, int pos, int h) {
		if (pos >= v.length) 
			return 0;
		
		return (v[pos] * h) + allPaths(v, 2*pos + 1, h/2) + allPaths(v, 2*pos + 2, h/2);
	}
	public double createGraphByArray(int[] arr)
	{
		int i;
		for (i=0;i<treeLength;i++) vec[i] = -1;
		i = 0;
		vec[i] = i;
		vec[i+1] = list.get(i).get(0);
		vec[i+2] = list.get(i).get(1);
		i++;
		while (i < treeLength) {
			ArrayList<Integer> l = list.get(vec[i]);
			if (l != null) 
			{
				vec[2*i+1] = l.get(0);
				vec[2*i+2] = l.get(1);
			}
			i++;
		}
		
		//printParents();
		for (i=0; i<vec.length;i++) {
			vec[i] = arr[vec[i]]; 
		}
		
		//System.out.println();
		double sum = allPaths(vec, 0, (int)Math.pow(2, height)/2);
		double totalSum = sum / totalPaths;
		//System.out.println(sum + "/"+totalPaths + ":"+totalSum);
		
		return totalSum;
		
	}
	
	public void createTriangles(double maxSum)
	{
		this.maxSum = maxSum;
		//printParents();
		int[] c = new int[length];
		
		iterate(c, 0, 9);
	}
	
	private void printParents() {
		System.out.println("Parents for heigth : " + height);
		for (Map.Entry<Integer, ArrayList<Integer>> entries : list.entrySet()) 
		{
			System.out.print(entries.getKey() + "->");
			for (int n : entries.getValue()) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TriangleMatches app = new TriangleMatches(4);
		//6291 height 3 with 10
		//app.createTriangles();
		//int[] arr = {3,4,3,9,2,1/*,4,5,3,2*/};
		//int [] arr = {4, 3, 1, 7, 4, 4};
		//System.out.print(app.createGraphByArray(arr));
		app.createTriangles(25);
		System.out.println("\n"+app.getTotal());

	}
	
	public void print(int[] a) 
	{
		for (int i=0;i<a.length;i++)
		{
			System.out.print(a[i] + " ");
		}
	}
	
	public int getTotal()
	{
		return this.total;
	}

}

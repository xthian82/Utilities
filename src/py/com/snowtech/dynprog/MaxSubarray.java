package py.com.snowtech.dynprog;

import java.util.Arrays;
import java.util.Scanner;


/*
8
1
1                   [1 1]
6
-1 -2 -3 -4 -5 -6   [-1 -1]
2
1 -2                [1 1]
3
1 2 3               [6 6]
1
-10                 [-10 -10]
6
1 -1 -1 -1 -1 5     [5 6]
4 
1 2 3 4             [10 10]
6
2 -1 2 3 4 -5       [10 11]
7
-3 2 -1 2 3 4 -5    [10 11]
 * */


public class MaxSubarray {
	static void solve(int[] arr) {
		
        int i, maxC = arr[0], maxG, maxHere = arr[0];
        
        for (i = 1; i < arr.length; i++) {
        	maxHere = Math.max(arr[i], maxHere + arr[i]);
        	maxC = Math.max(maxC, maxHere);
        }
        Arrays.sort(arr);
        maxG = arr[arr.length - 1];
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] + maxG > maxG) maxG += arr[i];
        }
        System.out.println(maxC + " " + maxG);
    }

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] array = new int[N];
			for (int a = 0; a < N; a++) {
				array[a] = sc.nextInt();
				
			}
			solve(array);
		}
		sc.close();
	}

}

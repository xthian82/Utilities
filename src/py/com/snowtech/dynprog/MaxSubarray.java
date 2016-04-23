package py.com.snowtech.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


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
	static void solveArray(int[] arr) {
		int length = arr.length;
		int[] sums = new int[length];
		
		int i, maxC = arr[0], maxG=0;
        sums[0] = arr[0];
		for (int j=1; j<length; j++) {
			for (i = 0; i < j; i++) {
				
				sums[i] += arr[j];
				if (sums[i] > maxC) {
					maxC = sums[i];
				}
			}
			sums[i] = arr[i];
			if (sums[i] > maxC) {
				maxC = sums[i];
			} 
		} 

		/*Arrays.sort(arr);
		maxG = arr[length - 1];
		for (i = length - 2; i >= 0; i--) {
			if (arr[i] + maxG > maxG)
				maxG += arr[i];
		}*/
		System.out.println(maxC + " " + maxG);
	}
	
	static void solve(int[] arr) {
		int i, length = arr.length;
		int[] sum = new int[length];
		sum[0] = arr[0];
		
		int maxC = Integer.MIN_VALUE;
		for (i=1; i<length; i++) {
			sum[i] = arr[i] + sum[i-1];
		}
		for (i=0;i<length-1; i++) {
			maxC = Math.max(maxC , Math.max(sum[i], sum[i] + sum[i+1]));
		}
		maxC = Math.max(maxC, sum[length-1]);
		
		sum[length-1] = arr[length-1];
		for (i=length-2; i>=0; i--) {
			sum[i] = arr[i] + sum[i+1];
		}
		for (i=0;i<length-1; i++) {
			maxC = Math.max(maxC, Math.max(sum[i], sum[i] + sum[i+1]));
		}
		maxC = Math.max(maxC, sum[0]);
		Arrays.sort(arr);
		int maxG = arr[length - 1];
		for (i = length - 2; i >= 0; i--) {
			if (arr[i] + maxG > maxG)
				maxG += arr[i];
		}
		System.out.println(maxC + " " + maxG);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] array = new int[N];
			long total = 0;
			for (int a = 0; a < N; a++) {
				array[a] = sc.nextInt();
				
				total += array[a];
			}
			solve(array); //, total);
		}
		sc.close();
	}

}

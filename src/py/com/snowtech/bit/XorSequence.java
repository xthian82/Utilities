package py.com.snowtech.bit;

import java.util.Scanner;

public class XorSequence {
	public static void main(String[] args) {
		long sum = 0; 
		for (long j = 0; j<=10000; j++) {
             sum ^= j;
             System.out.println(sum + " ");
         }
		 /*
		Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            long sum = 0, init = 0;
            for (long j = 0; j<=R; j++) {
                sum ^= j;
                System.out.print(sum + " ");
            }
            sum = init;
            for (long j=L+1; j<=R; j++) {
                init ^= j;
                sum ^= init;
            }
            System.out.println(sum);
        }
        in.close();*/
	}
}

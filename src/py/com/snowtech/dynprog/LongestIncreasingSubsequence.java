package py.com.snowtech.dynprog;

import java.util.ArrayList;
import java.util.List;

/*
The task is to find the length of the longest subsequence in a given array of integers such that all elements of the 
subsequence are sorted in ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the 
longest increasing subsequence is {15, 27, 38, 55, 65, 85}.
*/ 
public class LongestIncreasingSubsequence {
    public static void main(String[] a) {
        // int [] lsr = { 15, 27, 14, 38, 26, 55, 46, 65, 85 };
        int [] lsr = { 5,2,7,4,3,8 };
        
        
        System.out.println(getLongestSubsequence(lsr));
    }

    private static int getLongestSubsequence(int[] array) {
        List<List<Integer>> numbs = new ArrayList<>();
        

        List<Integer> l0 = new ArrayList<>();
        l0.add(array[0]);
        numbs.add(l0);
        int longestIndex = 0;
        int maxSize = 1;
        
        boolean found;
        for (int i=1; i<array.length; i++) {
            found = false;
            for (int j=longestIndex; j<numbs.size(); j++) {
                List<Integer> n = numbs.get(j);
                if (n.size() == 0 || n.get(n.size()-1) < array[i]) {
                    n.add(array[i]);
                    found = true;
                    if (n.size() > maxSize) {
                        maxSize = n.size();
                        longestIndex = j;
                    }
                }
            }
            
            if (!found) {
                List<Integer> l = new ArrayList<>(array[i]);
                numbs.add(l);
            }
        }
        
        return maxSize;
    }
}

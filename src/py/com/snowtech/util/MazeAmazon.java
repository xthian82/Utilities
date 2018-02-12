package py.com.snowtech.util;

import java.util.Arrays;

public class MazeAmazon {

    public static void main(String[] args) {
        //int [] nums = {2, 10, 5,4, 8};
        //int [] maxes = {3,1,7,8, 10};
        
        int [] nums = {1,4,2,4};
        int [] maxes = {3,5};
        
        int [] arr = counts(nums, maxes);
        
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
    
    static int[] counts(int[] nums, int[] maxes) {
        int [] solution = new int [maxes.length];
        int index = 0;
        
        Arrays.sort(nums);

        for (int m : maxes) {
            int id = findIndex(nums, m);
            solution[index++] = id;
        }
        
        return solution;
    }

    private static int findIndex(int[] nums, int m) {
        int begin = 0, end = nums.length, med;
        
        if (nums[nums.length-1] <= m) return nums.length;
        
        while (begin < end) {
            med = (begin + end)/2;
            if (nums[med] <= m && med < nums.length && nums[med+1] > m) {
                return med + 1;
            } else if (nums[med] > m) {
                end = med;
            } else {
                begin = med+1;
            }
        }
        
        return 0;
    }

}

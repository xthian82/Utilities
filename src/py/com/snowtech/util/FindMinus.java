package py.com.snowtech.util;

public class FindMinus {

    public static void main(String[] args) {
        int [][] arr = {
                {-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}
        };
        System.out.println(cal(arr));
    }

    static int cal(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        int value = 0;
        
        int i = 0;
        int j = N - 1;
        
        
        while (i < M && j >= 0) {
            if (arr[i][j] < 0) {
                i++;
                value += j + 1;
            } else {
                j--;
            }
        }
        
        return value;
    }

    
}

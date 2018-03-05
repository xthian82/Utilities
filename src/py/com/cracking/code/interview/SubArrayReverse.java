package py.com.cracking.code.interview;

public class SubArrayReverse {



    public static void main(String[] args) {
        int [] ar = {3, 4, 5, 1, 2};
        SubArrayReverse app = new SubArrayReverse();
        app.print(ar);
        app.swapSub(ar, 3);
        app.print(ar);
        app.commonOnSorted(new int[]{1, 5, 7, 8, 10, 15, 17, 20, 22, 25, 30},
                new int[]{3, 4, 10, 17, 18, 19, 20, 21, 23, 24, 25, 26, 27, 28, 29, 30});
    }

    void commonOnSorted(int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int left = 0, right = 0;

        while (left < leftLength && right < rightLength) {
            if (leftArray[left] == rightArray[right]) {
                System.out.print(leftArray[left] + " ");
                ++left; ++right;
            } else if (leftArray[left] < rightArray[right]) {
                ++left;
            } else {
                ++right;
            }
        }

        System.out.println();
    }

    void print(int [] m) {
        System.out.print("Items: ");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
        }
        System.out.println();
    }
    void swapSub(int[] matrix, int m) {
        int i, length = matrix.length;

        for (i = 0; i < m / 2; i++) {
            swap(matrix, i, m - i - 1);
        }

        for (i = 0; i < (length - m) / 2; i++) {
            swap(matrix, i + m, length - 1 - i);
        }

        for (i = 0; i < length / 2; i++) {
            swap(matrix, i, length - 1 - i);
        }
    }

    void swap(int[] matrix, int src, int tgt) {
        matrix[src] -= matrix[tgt];
        matrix[tgt] += matrix[src];
        matrix[src] = matrix[tgt] - matrix[src];
    }
}

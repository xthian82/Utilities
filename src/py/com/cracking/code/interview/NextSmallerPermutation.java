package py.com.cracking.code.interview;

public class NextSmallerPermutation {

    public static void main(String[] args) {
        // int[] n = {6, 7, 8, 3, 6, 5, 0, 2, 4};
        // int[] n = {4, 1, 2, 3};
        int[] n = {4, 7, 6, 3, 5, 9, 8, 7, 6, 2, 1, 0};

        print(next(n));
    }

    private static void print(int[] next) {
        System.out.println("---------------");
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println();
    }

    static int[] next(int[] number) {
        int j = number.length - 1;

        while (j > 0 && number[j - 1] > number[j]) {
            j--;
        }
        swap(number, j - 1, j);
        int i = j;
        while (i < number.length - 2 && i >= 0) {
            if (number[i] < number[i+1]) {
                swap(number, i, i+1);
                i++;
            } else {
                break;
            }
        }
        int k = number.length - 1;
        for (i = j; i < (number.length + j) / 2; i++, k--) {
            swap(number, i, k);
        }

        return number;
    }

    static void swap(int[] number, int a, int b) {
        if (a < 0 || b < 0 || a >= number.length || b >= number.length) {
            return;
        }
        int tmp = number[a];
        number[a] = number[b];
        number[b] = tmp;
    }
}

// 7 6 3 5| 9 0 => 7 6 3 9 0 5

// 7 6 3| 5 1 0 => 7 6 5 0 1 3

// 1 2 3 => 1 3 2

// 4 1 2 3 =>

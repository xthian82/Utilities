package py.com.snowtech.util;

public class NextPermute {

    public static void main(String[] args) {
        int [] numbers = {7, 1, 4, 8, 5, 3, 2}; // 7152348
        print(numbers);
        nextPermute(numbers);
        print(numbers);
    }

    private static void nextPermute(int[] numbers) {
        int i = numbers.length - 1;
        while (i > 0 && numbers[i - 1] > numbers[i]) {
            i--;
        }
        int j = i - 1;
        while (j < numbers.length - 1 && numbers[j] < numbers[j+1]) {
            j++;
        }
        swap(numbers, i, j);
        for (int k = 0; k < numbers.length - i; k++) {
            swap(numbers, k, numbers.length - 1 - k);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
        
    }

    private static void print(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

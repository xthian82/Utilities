package py.com.snowtech.sort;

public class ParallelBubble {

    public static void main(String[] args) {
        int ar[] = {4, 5, 6, 7, 8, 9, 0};

        sort(ar);
    }

    static void sort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) { // i even
                for (int j = 0; j < n / 2; j++) {
                    final int tmp = j;
                    System.out.println("* Comparing " + (2 * tmp) + " with " + (2 * tmp + 1));
                    // executor.submit(new Runnable(){
                    //    public void run(){
                    //        if (input[2*tmp]>input[2*tmp+1])
                    //            swap(2*tmp,2*tmp+1);}
                    //});
                }
            } else { // i odd
                for (int k = 0; k < n / 2 - 1; k++) {
                    final int tmp = k;
                    System.out.println("> Comparing " + (2 * tmp + 1) + " with " + (2 * tmp + 2));
                    // executor.submit(new Runnable(){
                    //    public void run(){
                    //        if (input[2*tmp+1]>input[2*tmp+2])
                    //            swap(2*tmp+1,2*tmp+2);}
                    // });
                }
            }
        }
    }
}

package py.com.snowtech.util;

public class AnagramAmazon {

    public static void main(String[] args) {
        String[] a = {
            "a",
            "jk",
            "abb",
            "mn",
            "abc"
        };
        
        String[] b = {
           "bb",
           "kj",
           "bbc",
           "op",
           "def"
        };
        
        int [] m = getMinimumDifference(a,b);
        for (int n : m) {
            System.out.println(n + " ");
        }

    }
    
    static int[] getMinimumDifference(String[] a, String[] b) {
        if (a.length != b.length) return null;
        
        int [] solution = new int [a.length];
        int index = 0;

        for (int i = 0; i<a.length; i++) {
            solution[index++] = findDifference(a[i], b[i]);
        }
        
        return solution;
    }

    private static int findDifference(String a, String b) {
        if (a == null || b == null) return -1;
        if (a.length() != b.length()) return -1;
        
        int [] ascii_a = new int[26];
        int [] ascii_b = new int[26];
        
        for (int i=0; i<a.length(); i++) {
            ascii_a[(int)(a.charAt(i) - 'a')]++;
            ascii_b[(int)(b.charAt(i) - 'a')]++;
        }
        
        int sum = 0;
        for (int i= 0; i<26; i++) {
            sum += Math.abs(ascii_a[i] - ascii_b[i]);
        }
            
        return sum/2;
    }

}

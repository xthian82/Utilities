package py.com.cracking.code.interview;

import org.junit.Assert;
import org.junit.Test;

public class NextSmallerPermutationTest {

    @Test
    public void checkNext() {
        Assert.assertArrayEquals(new int[]{6, 7, 8, 3, 6, 5, 0, 2, 4},
                NextSmallerPermutation.next(new int[]{6, 7, 8, 3, 6, 5, 0, 2, 4}));
    }

}
/*
5-


678365024
678365042


4-
34521
*/

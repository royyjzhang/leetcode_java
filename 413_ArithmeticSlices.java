/**
 * Created by zyj on 2017/7/10.
 */
import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0, current = 0;
        if (A.length < 3)
            return result;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                current += 1;
                result += current;
            }
            else {
                current = 0;
            }
        }
        return result;
    }
}

public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2, 3, 4};
        System.out.println(solution.numberOfArithmeticSlices(A));
    }
}

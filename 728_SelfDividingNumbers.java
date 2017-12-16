import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<Integer>();
        for (int num = left; num <= right; num++) {
            int test = num;
            while (test > 0) {
                if ((test % 10 == 0) || (num % (test % 10) != 0)) {
                    break;
                }
                test /= 10;
            }
            if (test == 0) {
                results.add(num);
            }
        }
        return results;
    }
}

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 1, right = 22;
        Solution solution = new Solution();
        List<Integer> results = solution.selfDividingNumbers(left, right);
        for (Integer result : results) {
            System.out.println(result);
        }
    }
}

/**
 * Created by zyj on 2017/7/15.
 */
import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0, i = 0, j = nums.length - 1;
        while (i < j) {
            result += nums[j] - nums[i];
            i++;
            j--;
        }
        return result;
    }
}

public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.minMoves2(nums));
    }
}

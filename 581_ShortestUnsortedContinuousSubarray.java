/**
 * Created by zyj on 2017/6/25.
 */
import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, begin = -1, end = -2, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[n - i - 1]);
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                end = i;
            if (nums[n - i - 1] > min)
                begin = n - i - 1;
        }
        return end - begin + 1;
    }
}

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}

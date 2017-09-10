/**
 * Created by zyj on 2017/7/10.
 */
import java.util.*;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if ((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid + 1]))
                return nums[mid];
            else if ((nums[mid] == nums[mid + 1]) && (mid % 2 == 0))
                low = mid + 1;
            else if ((nums[mid] == nums[mid - 1]) && (mid % 2 == 1))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }
}

public class SingleElementinSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(solution.singleNonDuplicate(nums));
    }
}

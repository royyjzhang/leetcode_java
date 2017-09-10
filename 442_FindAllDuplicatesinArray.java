/**
 * Created by zyj on 2017/7/9.
 */
import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}

public class FindAllDuplicatesinArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result;
        result = solution.findDuplicates(nums);
        for (int i = 0;i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

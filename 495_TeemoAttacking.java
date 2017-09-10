/**
 * Created by zyj on 2017/7/15.
 */

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0, start = 0, end = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
                end = start + duration;
            }
            else {
                end = timeSeries[i] + duration;
            }
        }
        result += end - start;
        return result;
    }
}

public class TeemoAttacking {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] timeSeries = {1, 3};
        int duration = 2;
        System.out.println(solution.findPoisonedDuration(timeSeries, duration));
    }
}

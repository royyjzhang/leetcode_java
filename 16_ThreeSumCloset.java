/**
 * Created by zyj on 2016/10/5.
 */
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length,i,j,k,mindiff=Integer.MAX_VALUE,now=0, nowdiff=0,minsum=0;
        if (n==0) {
            return 0;
        }
        Arrays.sort(nums);
        i=0;
        while (i<n-1) {
            j=i+1;
            k=n-1;
            while (j<k) {
                now=nums[i]+nums[j]+nums[k];
                nowdiff=Math.abs(now-target);
                if (nowdiff==0) {
                    return now;
                }
                if (mindiff>nowdiff) {
                    mindiff=nowdiff;
                    minsum=now;
                }
                if (now>target) {
                    k--;
                }
                else {
                    j++;
                }
            }
            i++;
        }
        return minsum;
    }
}

public class ThreeSumCloset {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{-1,2,1,-4};
        int target=1;
        System.out.println(solution.threeSumClosest(nums,target));
    }
}

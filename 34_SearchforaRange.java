/**
 * Created by zyj on 2016/10/4.
 */
import java.util.*;

class Solution {
    private int bisearch(int[] nums, int target, int left, int right, boolean direction) {
        int mid;
        while (left<=right) {
            mid=(left+right)>>1;
            if (nums[mid]==target) {
                if (!direction) {
                    if ((mid-1>=left) && (nums[mid-1]==nums[mid])) {
                        right=mid-1;
                    }
                    else {
                        return mid;
                    }
                }
                else{
                    if ((mid+1<=right) && (nums[mid+1]==nums[mid])) {
                        left=mid+1;
                    }
                    else {
                        return mid;
                    }
                }
            }
            else if (nums[mid]>target) {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        if (direction) {
            return 1;
        }
        else {
            return -1;
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        boolean direction=false;
        if (nums.length==0) {
            return result;
        }
        result[0]=bisearch(nums,target,0,nums.length-1,direction);
        direction=true;
        if (result[0]==-1) {
            return result;
        }
        result[1]=bisearch(nums,target,result[0],nums.length-1,direction);
        return result;
    }
}

public class SearchforaRange {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] result;
        int[] nums=new int[]{5,5,7,7,8,8,10};
        int target=5;
        result=solution.searchRange(nums,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

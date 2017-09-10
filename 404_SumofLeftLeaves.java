/**
 * Created by zyj on 2017/4/16.
 */
import java.util.*;

//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    private int result = 0;
    private void getLeftLeavesSum(TreeNode root, boolean leftSonFlag) {
        if ((root.left == null) && (root.right == null) && (leftSonFlag)) {
            result += root.val;
            return;
        }
        if (root.left != null)
            getLeftLeavesSum(root.left, true);
        if (root.right != null)
            getLeftLeavesSum(root.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if ((root == null) || ((root.left == null) && (root.right == null))) {
            return result;
        }
        getLeftLeavesSum(root, true);
        return result;
    }
}

public class SumofLeftLeaves {
    public static void main (String[] args) {
        TreeNode root, p;
        Solution s = new Solution();
        int result;
        root = new TreeNode(3);
        p = new TreeNode(9);
        root.left = p;
        p = new TreeNode(20);
        root.right = p;
        p = new TreeNode(15);
        root.right.left = p;
        p = new TreeNode(7);
        root.right.right = p;
        result = s.sumOfLeftLeaves(root);
        System.out.println("result is " + result);
    }
}

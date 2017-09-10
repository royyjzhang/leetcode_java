/**
 * Created by zyj on 2017/4/23.
 */
import java.util.*;

/**
 * Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return diameter;
        heightOfTree(root);
        return diameter;
    }
    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int lh, rh;
        lh = heightOfTree(root.left);
        rh = heightOfTree(root.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode root, p;
        Solution solution = new Solution();
        root = new TreeNode(1);
        p = new TreeNode(2);
        root.left = p;
        p = new TreeNode(3);
        root.right = p;
        p = new TreeNode(4);
        root.left.left = p;
        p = new TreeNode(5);
        root.left.right = p;
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}

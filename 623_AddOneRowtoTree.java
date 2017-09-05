/**
 * Created by zyj on 2017/7/26.
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        else if (d == 0) {
            TreeNode newroot = new TreeNode(v);
            newroot.right = root;
            return newroot;
        }
        if (root == null) {
            return root;
        }
        else if (d == 2) {
            root.left = addOneRow(root.left, v, 1);
            root.right = addOneRow(root.right, v, 0);
            return root;
        }
        else if (d > 2) {
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
        }
        return root;
    }
}

public class AddOneRowtoTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int v = 1, d = 2;
        TreeNode root = new TreeNode(4), p;
        p = new TreeNode(2);
        root.left = p;
        p = new TreeNode(6);
        root.right = p;
        p = new TreeNode(3);
        root.left.left = p;
        p = new TreeNode(1);
        root.left.right = p;
        p = new TreeNode(5);
        root.right.left = p;
        root = solution.addOneRow(root, v, d);
        TreePrint(root);
    }
    public static void TreePrint(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        TreePrint(root.left);
        TreePrint(root.right);
    }
}

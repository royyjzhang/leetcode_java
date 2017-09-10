/**
 * Created by zyj on 2017/6/11.
 */

import java.util.*;

/**
 * Definition for a binary tree node. */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newroot, node1, node2;
        newroot = recursiveMerge(t1,t2);
        return newroot;
    }
    private TreeNode recursiveMerge(TreeNode t1, TreeNode t2) {
        if ((t1 == null) && (t2 == null))
            return null;
        TreeNode now = new TreeNode(0);
        if (t1 == null) {
            now.val = t2.val;
            now.left = recursiveMerge(null, t2.left);
            now.right = recursiveMerge(null, t2.right);
        }
        else if (t2 == null) {
            now.val = t1.val;
            now.left = recursiveMerge(t1.left, null);
            now.right = recursiveMerge(t1.right, null);
        }
        else {
            now.val = t1.val + t2.val;
            now.left = recursiveMerge(t1.left, t2.left);
            now.right = recursiveMerge(t1.right, t2.right);
        }
        return now;
    }
}

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root1, root2, p;
        Solution solution = new Solution();
        root1 = new TreeNode(1);
        root2 = new TreeNode(2);
        p = new TreeNode(3);
        root1.left = p;
        p = new TreeNode(2);
        root1.right = p;
        p = new TreeNode(5);
        root1.left.left = p;
        p = new TreeNode(1);
        root2.left = p;
        p = new TreeNode(3);
        root2.right = p;
        p = new TreeNode(4);
        root2.left.right = p;
        p = new TreeNode(7);
        root2.right.right = p;
        System.out.println("Tree 1");
        printTree(root1);
        System.out.println("Tree 2");
        printTree(root2);
        System.out.println("New Tree");
        printTree(solution.mergeTrees(root1, root2));
    }
    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        String s = Integer.toString(root.val);
        if (root.left != null)
            s = s + "left->" + root.left.val;
        if (root.right != null)
            s = s + "right->" + root.right.val;
        System.out.println(s);
        printTree(root.left);
        printTree(root.right);
    }
}

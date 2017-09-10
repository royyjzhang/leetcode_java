/**
 * Created by zyj on 2017/6/24.
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
     Integer prev = null;
     int max = 0;
     int count = 1;
     private void inorder_tranverse(TreeNode root, List<Integer> list) {
         if (root == null)
             return;
         inorder_tranverse(root.left, list);
         if (prev != null) {
             if (root.val == prev) {
                 count++;
             }
             else {
                 count = 1;
             }
         }
         if (count > max) {
             max = count;
             list.clear();
             list.add(root.val);
         }
         else if (count == max) {
             list.add(root.val);
         }
         prev = root.val;
         inorder_tranverse(root.right, list);

     }

     public int[] findMode(TreeNode root) {
         if (root == null)
             return new int[0];
         List<Integer> list = new ArrayList<Integer>();
         inorder_tranverse(root, list);
         int[] result = new int[list.size()];
         for (int i = 0; i < result.length; i++) {
             result[i] = list.get(i);
         }
         return result;
     }
}

public class FindModeinBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1), p;
        Solution solution = new Solution();
        int[] result;
        p = new TreeNode(2);
        root.right = p;
        p = new TreeNode(2);
        root.right.left = p;
        result = solution.findMode(root);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

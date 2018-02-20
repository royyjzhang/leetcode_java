import java.util.Deque;
import java.util.LinkedList;
/**
 * Definition for a binary tree node. */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return null;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode currentNode = new TreeNode(nums[i]);
            while ((!treeNodeDeque.isEmpty()) && (treeNodeDeque.peek().val < nums[i])) {
                currentNode.left = treeNodeDeque.peek();
                treeNodeDeque.pop();
            }
            if (!treeNodeDeque.isEmpty()) {
                treeNodeDeque.peek().right = currentNode;
            }
            treeNodeDeque.push(currentNode);
        }
        return treeNodeDeque.getLast();
    }
}

public class MaximumBinaryTree {
     public static void main(String[] args) {
         int[] nums = {3, 2, 1, 6, 0, 5};
         Solution solution = new Solution();
         TreeNode result;
         result = solution.constructMaximumBinaryTree(nums);
         printTree(result);
     }
     public static void printTree(TreeNode result) {
         if (result == null) {
             return;
         }
         System.out.println(result.val);
         printTree(result.left);
         printTree(result.right);
     }
}

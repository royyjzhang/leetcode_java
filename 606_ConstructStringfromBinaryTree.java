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
    private StringBuilder result = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        preorderTraverse(t);
        return result.toString();
    }
    private void preorderTraverse(TreeNode now) {
        result.append(now.val);
        if (now.left != null) {
            result.append('(');
            preorderTraverse(now.left);
            result.append(')');
        }
        if (now.right != null) {
            if (now.left == null)
                result.append("()");
            result.append("(");
            preorderTraverse(now.right);
            result.append(')');
        }
    }
}

public class ConstructStringfromBinaryTree {
    public static void main(String[] args) {
        TreeNode root1, p;
        Solution solution = new Solution();
        root1 = new TreeNode(1);
        p = new TreeNode(3);
        root1.left = p;
        p = new TreeNode(2);
        root1.right = p;
        p = new TreeNode(5);
        root1.left.left = p;
        System.out.println("Tree");
        printTree(root1);
        System.out.println(solution.tree2str(root1));
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

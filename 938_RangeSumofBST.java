/**
 * Definition for a binary tree node.
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int result = 0;
    private void dFSwithReduce(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }else if ((root.val >= L) && (root.val <= R)) {
            result += root.val;
            dFSwithReduce(root.left, L, R);
            dFSwithReduce(root.right, L, R);
        } else if (root.val < L) {
            dFSwithReduce(root.right, L, R);
        } else if (root.val > R) {
            dFSwithReduce(root.left, L, R);
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        dFSwithReduce(root, L, R);
        return result;
    }
}

public class RangeSumofBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int L = 7, R = 15;
        TreeNode root = new TreeNode(10);
        TreeNode p = new TreeNode(5);
        root.left = p;
        p = new TreeNode(15);
        root.right = p;
        p = new TreeNode(3);
        root.left.left = p;
        p = new TreeNode(7);
        root.left.right = p;
        p = new TreeNode(18);
        root.right.right = p;
        System.out.println(solution.rangeSumBST(root, L, R));
    }
}

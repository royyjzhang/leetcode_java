/**
 * Created by zyj on 2016/10/6.
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
    private TreeNode build(int[] preorder, int[] inorder, int left, int right, int index) {
        TreeNode root;
        if (left==right) {
            root=new TreeNode(inorder[left]);
            return root;
        }
        int i=left;
        for (i=left;i<=right;i++) {
            if (inorder[i]==preorder[index]) {
                break;
            }
        }
        root=new TreeNode(inorder[i]);
        if (i!=left) {
            root.left = build(preorder, inorder, left, i - 1, index + 1);
        }
        else {
            root.left=null;
        }
        if (i!=right) {
            root.right=build(preorder,inorder,i+1,right,index+1+i-left);
        }
        else {
            root.right=null;
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length,m=inorder.length;
        if ((n==0) || (m==0) || (n!=m)) {
            return null;
        }
        TreeNode root;
        root=build(preorder,inorder,0,m-1,0);
        return root;
    }
}

public class ConstructTreefromPreandInorder {
    public static void outputTree(TreeNode root) {
        System.out.print("Val: "+root.val);
        if (root.left!=null) {
            System.out.print("Left: "+root.left.val);
        }
        else {
            System.out.print("Left: Null");
        }
        if (root.right!=null) {
            System.out.print("Right: "+root.right.val);
        }
        else {
            System.out.print("Right: Null");
        }
        System.out.println();
        if (root.left!=null) {
            outputTree(root.left);
        }
        if (root.right!=null) {
            outputTree(root.right);
        }
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] preorder=new int[]{1,2,3,4,5,6},inorder=new int[]{3,2,4,1,5,6};
        TreeNode root;
        root=solution.buildTree(preorder,inorder);
        if (root==null) {
            System.out.println("Null");
        }
        outputTree(root);
    }
}

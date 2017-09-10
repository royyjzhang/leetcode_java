/**
 * Created by zyj on 2016/10/5.
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
    private List<List<Integer>> result;
    private List<Integer> line;
    private void deepSearch(TreeNode root, int sum, int current) {
        line.add(root.val);
        current+=root.val;
        if ((root.left==null) && (root.right==null)) {
            if (current==sum) {
                List<Integer> now=new ArrayList<Integer>(line);
                result.add(now);
            }
            current-=root.val;
            line.remove(line.size()-1);
            return;
        }
        if (root.left!=null) {
            deepSearch(root.left,sum,current);
        }
        if (root.right!=null) {
            deepSearch(root.right,sum,current);
        }
        current-=root.val;
        line.remove(line.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<List<Integer>>();
        line=new ArrayList<Integer>();
        if (root==null) {
            return result;
        }
        deepSearch(root,sum,0);
        return result;
    }
}

public class PathSumII {
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> result;
        int sum=22;
        TreeNode root,p;
        root=new TreeNode(5);
        p=new TreeNode(4);
        root.left=p;
        p=new TreeNode(11);
        root.left.left=p;
        p=new TreeNode(7);
        root.left.left.left=p;
        p=new TreeNode(2);
        root.left.left.right=p;
        p=new TreeNode(8);
        root.right=p;
        p=new TreeNode(13);
        root.right.left=p;
        p=new TreeNode(4);
        root.right.right=p;
        p=new TreeNode(5);
        root.right.right.left=p;
        p=new TreeNode(1);
        root.right.right.right=p;
        result=solution.pathSum(root,sum);
        System.out.println("[");
        for (int i=0;i<result.size();i++) {
            System.out.print("[");
            for (int j=0;j<result.get(i).size()-1;j++) {
                System.out.print(result.get(i).get(j)+",");
            }
            System.out.println(result.get(i).get(result.get(i).size()-1)+"]");
        }
        System.out.println("]");
    }
}

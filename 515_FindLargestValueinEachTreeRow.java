/**
 * Created by zyj on 2017/7/10.
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Queue<Map<TreeNode, Integer>> queue = new LinkedList<Map<TreeNode, Integer>>();
        Integer currentLevel = 0, currentMax = root.val;
        Map<TreeNode, Integer> newNode, currentNode;
        newNode = new HashMap<TreeNode, Integer>();
        newNode.put(root, 0);
        queue.offer(newNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            for (TreeNode key : currentNode.keySet()) {
                if (currentNode.get(key) > currentLevel) {
                    currentLevel = currentNode.get(key);
                    result.add(currentMax);
                    currentMax = key.val;
                }
                else if (key.val > currentMax) {
                    currentMax = key.val;
                }
                if (key.left != null) {
                    newNode = new HashMap<TreeNode, Integer>();
                    newNode.put(key.left, currentLevel + 1);
                    queue.offer(newNode);
                }
                if (key.right != null) {
                    newNode = new HashMap<TreeNode, Integer>();
                    newNode.put(key.right, currentLevel + 1);
                    queue.offer(newNode);
                }
            }
        }
        result.add(currentMax);
        return result;
    }
}

public class FindLargestValueinEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1), p;
        List<Integer> result;
        p = new TreeNode(3);
        root.left = p;
        p = new TreeNode(2);
        root.right = p;
        p = new TreeNode(5);
        root.left.left = p;
        p = new TreeNode(3);
        root.left.right = p;
        p = new TreeNode(9);
        root.right.right = p;
        p = new TreeNode(2);
        root.left.left.left = p;
        result = solution.largestValues(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

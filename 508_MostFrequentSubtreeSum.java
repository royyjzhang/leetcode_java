/**
 * Created by zyj on 2017/7/14.
 */

/**
 * Definition for a binary tree node.
 */
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private Map<Integer, Integer> frequency = new LinkedHashMap<Integer, Integer>();
    private int inOrderTraverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = inOrderTraverse(root.left), right = inOrderTraverse(root.right), current = 0;
        current = left + right + root.val;
        if (frequency.containsKey(current)) {
            frequency.put(current, frequency.get(current) + 1);
        }
        else {
            frequency.put(current, 1);
        }
        return current;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            int[] result = {};
            return result;
        }
        int max = 0;
        List<Integer> maxinums = new ArrayList<Integer>();
        inOrderTraverse(root);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(frequency.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });
        max = entries.get(entries.size() - 1).getValue();
        for (Integer sum : frequency.keySet()) {
            if (frequency.get(sum) == max) {
                maxinums.add(sum);
            }
        }
        int[] result = new int[maxinums.size()];
        for (int i = 0; i < maxinums.size(); i++) {
            result[i] = maxinums.get(i).intValue();
        }
        return result;
    }
}

public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3), p;
        p = new TreeNode(1);
        root.left = p;
        p = new TreeNode(5);
        root.right = p;
        p = new TreeNode(0);
        root.left.left = p;
        p = new TreeNode(2);
        root.left.right = p;
        p = new TreeNode(3);
        root.left.right.right = p;
        p = new TreeNode(4);
        root.right.left = p;
        p = new TreeNode(6);
        root.right.right = p;
        int[] result = solution.findFrequentTreeSum(root);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

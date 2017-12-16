class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder test = new StringBuilder();
        int result = 0;
        while (test.length() < B.length()) {
            test.append(A);
            result++;
        }
        if (test.toString().contains(B))
            return result;
        if (test.append(A).toString().contains(B))
            return ++result;
        return -1;
    }
}

public class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abcd", b = "cdabcdab";
        System.out.println(solution.repeatedStringMatch(a, b));
    }
}

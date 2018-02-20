import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        Set<Character> jewelSet = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            jewelSet.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (jewelSet.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}

public class JewelsandStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAAssss";
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones(J, S));
    }
}

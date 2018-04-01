import java.util.HashSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dictionary = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> expression = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray()) {
                code.append(dictionary[c - 'a']);
            }
            expression.add(code.toString());
        }
        return expression.size();
    }
}

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(words));
    }
}

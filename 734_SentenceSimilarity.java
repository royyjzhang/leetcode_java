import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, Set<String>> dictionary = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            if (!dictionary.containsKey(pairs[i][0])) {
                dictionary.put(pairs[i][0], new HashSet<String>());
            }
            dictionary.get(pairs[i][0]).add(pairs[i][1]);
        }
        for (int i = 0; i < words1.length; i++) {
            if ((!words1[i].equals(words2[i])) && (!dictionary.getOrDefault(words1[i], new HashSet<String>()).contains(words2[i])) && (!dictionary.getOrDefault(words2[i], new HashSet<String>()).contains(words1[i])))
                return false;
        }
        return true;
    }
}

public class SentenceSimilarity {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words1 = {"great", "drama"}, words2 = {"fine", "talent"};
        String[][] pairs = {{"great", "fine"},{"drama", "talent"}};
        System.out.println(solution.areSentencesSimilar(words1, words2, pairs));
    }
}

/**
 * Created by zyj on 2017/7/26.
 */
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if ((dict == null) || (dict.size() == 0)) {
            return sentence;
        }
        Set<String> dictSet = new HashSet<String>();
        for (int i = 0; i < dict.size(); i++) {
            dictSet.add(dict.get(i));
        }
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        String prefix = "";
        for (int i = 0; i < words.length; i++) {
            int wordLength = words[i].length();
            for (int divider = 1; divider <= wordLength; divider++) {
                prefix = words[i].substring(0, divider);
                if (dictSet.contains(prefix)) {
                    break;
                }
            }
            if (i == words.length - 1) {
                result.append(prefix);
            }
            else {
                result.append(prefix + " ");
            }
        }
        return result.toString();
    }
}
public class ReplaceWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dict, sentence));
    }
}

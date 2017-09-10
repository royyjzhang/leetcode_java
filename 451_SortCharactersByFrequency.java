/**
 * Created by zyj on 2017/7/16.
 */
import com.sun.deploy.util.StringUtils;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String frequencySort(String s) {
        Map<String, Integer> frequency = new HashMap<String, Integer>();
        String result = "", letter;
        String[] bucket = new String[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            letter = Character.toString(s.charAt(i));
            if (frequency.containsKey(letter)) {
                frequency.put(letter, frequency.get(letter) + 1);
            }
            else {
                frequency.put(letter, 1);
            }
        }
        for (Map.Entry<String, Integer> letterFrequency : frequency.entrySet()) {
            if (bucket[letterFrequency.getValue()] == null) {
                bucket[letterFrequency.getValue()] = new String(String.join("", Collections.nCopies(letterFrequency.getValue(), letterFrequency.getKey())));
            }
            else {
                bucket[letterFrequency.getValue()] += String.join("", Collections.nCopies(letterFrequency.getValue(), letterFrequency.getKey()));
            }
        }
        for (int i = s.length(); i > 0; i--) {
            if (bucket[i] != null) {
                result += bucket[i];
            }
        }
        return result;
    }
}

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "tree";
        System.out.println(solution.frequencySort(s));
    }
}

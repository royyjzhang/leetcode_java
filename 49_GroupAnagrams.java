/**
 * Created by zyj on 2016/10/4.
 */
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<String, List<String>>();
        List<List<String>> result=new ArrayList<List<String>>();
        String s;
        for (int i=0;i<strs.length;i++) {
            s=strs[i];
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for (List<String> l:map.values()) {
            result.add(l);
        }
        return result;
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result;
        result=solution.groupAnagrams(strs);
        System.out.println("[");
        for (int i=0;i<result.size();i++) {
            System.out.print("[");
            for (int j=0;j<result.get(i).size();j++)
                System.out.print(result.get(i).get(j)+" ");
            System.out.println("]");
        }
        System.out.println("]");
    }
}

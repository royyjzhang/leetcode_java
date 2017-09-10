/**
 * Created by zyj on 2017/4/17.
 */
import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<points.length;i++) {
            map.clear();
            for (int j=0;j<points.length;j++) {
                if (i!=j) {
                    int distance = (int) Math.floor(Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2));
                    if (!(map.containsKey(distance))) {
                        map.put(distance, 1);
                    } else {
                        map.put(distance, map.get(distance) + 1);
                    }
                }
            }
            for (Integer key : map.keySet()) {
                if (map.get(key)>=2) {
                    result += map.get(key) * (map.get(key) - 1);
                }
            }
        }
        return result;
    }
}

public class NumberofBoomerangs {
    public static void main (String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result;
        Solution s = new Solution();
        result = s.numberOfBoomerangs(points);
        System.out.println(result);
    }
}

/**
 * Created by zyj on 2016/10/6.
 */
import java.util.*;

class Solution {
    private int aux(int n, boolean direction) {
        if (n==1) {
            return 1;
        }
        if (direction) {
            return 2*aux(n/2,false);
        }
        else {
            if (n%2==0) {
                return 2*aux(n/2,true)-1;
            }
            else {
                return 2*aux(n/2,true);
            }
        }
    }
    public int lastRemaining(int n) {
        return aux(n,true);
    }
}

public class EliminationGame {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=9;
        System.out.println(solution.lastRemaining(n));
    }
}

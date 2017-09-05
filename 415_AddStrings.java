/**
 * Created by zyj on 2017/4/23.
 */
import java.util.*;

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry;
        String result = "";
        StringBuilder resultBuilder = new StringBuilder();
        if ((i < 0) || (j < 0))
            return result;
        carry = 0;
        while ((i >= 0) || (j >= 0) || (carry > 0)) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0, b = j >= 0 ? num2.charAt(j) - '0' : 0;
            resultBuilder.insert(0, (a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            i--;
            j--;
        }
        result = resultBuilder.toString();
        return result;
    }
}

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "1234", num2 = "567";
        Solution solution = new Solution();
        System.out.println(solution.addStrings(num1, num2));
    }
}

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder key = new StringBuilder();
        String result = "";
        int currentLength = K;
        S = S.toUpperCase();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                key.insert(0, S.charAt(i));
                currentLength--;
            }
            if (currentLength == 0) {
                key.insert(0, '-');
                currentLength = K;
            }
        }
        if ((key.length() > 0) && (key.charAt(0) == '-')) {
            key.delete(0, 1);
        }
        result = key.toString();
        return result;
    }
}

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "---";
        int k = 4;
        System.out.println(solution.licenseKeyFormatting(s, k));
    }
}

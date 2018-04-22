class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()], position = new int[S.length()];
        int charNumber = 0, currenttestChar = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                position[charNumber] = i;
                charNumber++;
            }
        }
        for (int i = 0; i < S.length(); i++) {
            if (currenttestChar + 1 < charNumber) {
                if (i > position[currenttestChar + 1]) {
                    currenttestChar++;
                }
                if (Math.abs(position[currenttestChar] - i) < Math.abs(position[currenttestChar + 1] - i)) {
                    result[i] = Math.abs(position[currenttestChar] - i);
                }
                else {
                    result[i] =Math.abs(position[currenttestChar + 1] - i);
                }
            }
            else {
                result[i] = Math.abs(position[currenttestChar] - i);
            }
        }
        return result;
    }
}

public class ShortestDistancetoaCharacter {
    public static void main(String[] args) {
        String S = "aaab";
        char C = 'b';
        Solution solution = new Solution();
        int[] result;
        result = solution.shortestToChar(S, C);
        for (int item : result) {
            System.out.print(item + ", ");
        }
    }
}

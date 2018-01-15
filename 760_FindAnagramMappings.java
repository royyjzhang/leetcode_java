class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        int[] checked = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((A[i] == B[j]) && (checked[j] == 0)) {
                    result[i] = j;
                    checked[j] = 1;
                    break;
                }
            }
        }
        return result;
    }
}

public class FindAnagramMappings {
    public static void main(String[] args) {
        int[] A = {21,5,74,5,74,21}, B = {21,5,74,74,5,21}, result;
        Solution solution = new Solution();
        result = solution.anagramMappings(A, B);
        for (int position : result) {
            System.out.println(position);
        }
    }
}

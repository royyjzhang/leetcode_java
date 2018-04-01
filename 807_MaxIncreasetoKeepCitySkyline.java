class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n], col = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    row[i] = grid[i][j];
                }
                else {
                    row[i] = Math.max(row[i], grid[i][j]);
                }
                if (i == 0) {
                    col[j] = grid[i][j];
                }
                else {
                    col[j] = Math.max(col[j], grid[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return result;
    }
}

public class MaxIncreasetoKeepCitySkyline {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int outout = 0;
        Solution solution = new Solution();
        System.out.println(solution.maxIncreaseKeepingSkyline(grid));
    }
}

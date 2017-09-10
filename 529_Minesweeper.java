/**
 * Created by zyj on 2017/7/16.
 */
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n;
        if (m == 0) {
            return board;
        }
        n = board[0].length;
        if (n == 0) {
            return board;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] currentPoint, newPoint;
        int mineCount = 0, r = 0, c = 0;
        queue.offer(click);
        while (!queue.isEmpty()) {
            currentPoint = queue.poll();
            if (board[currentPoint[0]][currentPoint[1]] == 'M') {
                board[currentPoint[0]][currentPoint[1]] = 'X';
                return board;
            }
            mineCount = 0;
            for (int row = -1; row < 2; row++) {
                for (int col = -1; col < 2; col ++) {
                    r = currentPoint[0] + row;
                    c = currentPoint[1] + col;
                    if (!((row == 0) && (col == 0)) &&
                        !((r < 0) || (r >= m) || (c < 0) || (c >= n))) {
                        if ((board[r][c] == 'M') || (board[r][c] == 'X')){
                            mineCount++;
                        }
                    }
                }
            }
            if (mineCount > 0) {
                board[currentPoint[0]][currentPoint[1]] = (char)(mineCount + '0');
            }
            else {
                board[currentPoint[0]][currentPoint[1]] = 'B';
                for (int row = -1; row < 2; row++) {
                    for (int col = -1; col < 2; col++) {
                        r = currentPoint[0] + row;
                        c = currentPoint[1] + col;
                        if (!((row == 0) && (col == 0)) &&
                            !((r < 0) || (r >= m) || (c < 0) || (c >= n))) {
                            if (board[r][c] == 'E') {
                                newPoint = new int[]{r, c};
                                queue.offer(newPoint);
                                board[r][c] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}

public class Minesweeper {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][] {{'E', 'E', 'E', 'E', 'E'},
                                       {'E', 'E', 'M', 'E', 'E'},
                                       {'E', 'E', 'E', 'E', 'E'},
                                       {'E', 'E', 'E', 'E', 'E'}},
                 result;
        int[] click1 = new int[] {3, 0}, click2 = new int[] {1, 2};
        result = solution.updateBoard(board, click1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        result = solution.updateBoard(result, click2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}

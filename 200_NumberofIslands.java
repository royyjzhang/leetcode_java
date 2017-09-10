/**
 * Created by zyj on 2016/10/4.
 */
import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int m=0,n=0,i=0,j=0,result=0;
        m=grid.length;
        if (m==0) {
            return 0;
        }
        n=grid[0].length;
        if (n==0) {
            return 0;
        }
        //boolean[][] checked=new boolean[m][n];
        Queue<int[]> q=new LinkedList<int[]>();
        int[] point;
        for (i=0;i<m;i++) {
            for (j=0;j<n;j++) {
                if ((grid[i][j]=='1')) {
                    grid[i][j]='2';
                    q.add(new int[] {i,j});
                    result+=1;
                    while (!q.isEmpty()) {
                        point=q.remove();
                        //q.poll();
                        if ((point[0]>0) && (grid[point[0]-1][point[1]]=='1')) {
                            grid[point[0]-1][point[1]]='2';
                            q.add(new int[] {point[0]-1,point[1]});
                        }
                        if ((point[0]<m-1) && (grid[point[0]+1][point[1]]=='1')) {
                            grid[point[0]+1][point[1]]='2';
                            q.add(new int[] {point[0]+1,point[1]});
                        }
                        if ((point[1]>0) && (grid[point[0]][point[1]-1]=='1')) {
                            grid[point[0]][point[1]-1]='2';
                            q.add(new int[] {point[0],point[1]-1});
                        }
                        if ((point[1]<n-1) && (grid[point[0]][point[1]+1]=='1')) {
                            grid[point[0]][point[1]+1]='2';
                            q.add(new int[] {point[0],point[1]+1});
                        }
                    }
                }
            }
        }
        return result;
    }
}
public class NumberofIslands {
    public static void main(String[] args) {
        Solution solution=new Solution();
        //char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int result=0;
        result=solution.numIslands((grid));
        System.out.println(result);
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakingALargeIsland {
    class DisjointUnion {
        int[] parent;
        int[] size;
        public DisjointUnion(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x) {
            int finding = x;
            while (this.parent[finding] != finding) {
                finding = this.parent[finding];
            }
            while (this.parent[x] != finding) {
                int temp = this.parent[x];
                this.parent[x] = finding;
                x = temp;
            }
            return finding;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (this.size[rootX] > this.size[rootY]) {
                    this.parent[rootY] = rootX;
                    this.size[rootX] += this.size[rootY];
                    this.size[rootY] = this.size[rootX];
                } else {
                    this.parent[rootX] = rootY;
                    this.size[rootX] += this.size[rootY];
                    this.size[rootY] = this.size[rootX];
                }
            }
        }

        public int getSize(int x) {
            int rootX = find(x);
            return this.size[rootX];
        }
    }

    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            throw new RuntimeException("invalid input");
        }
        DisjointUnion disjointUnion = new DisjointUnion(n * n);
        List<Node> zeroNodes = new ArrayList<>();
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zeroNodes.add(new Node(i, j));
                } else if (grid[i][j] == 1) {
                    ArrayDeque<Node> queue = new ArrayDeque<>();
                    queue.addLast(new Node(i, j));
                    grid[i][j] = 2;
                    while (!queue.isEmpty()) {
                        Node current = queue.removeFirst();
                        for (int[] direction : directions) {
                            int nextX = current.x + direction[0];
                            int nextY = current.y + direction[1];
                            if ((nextX >= 0) && (nextX < n) && (nextY >= 0) && (nextY < n) && (grid[nextX][nextY] == 1)) {
                                disjointUnion.union(current.x * n + current.y, nextX * n + nextY);
                                grid[nextX][nextY] = 2;
                                queue.addLast(new Node(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (Node zeroNode : zeroNodes) {
            int currentSize = 1;
            HashSet<Integer> existingUnion = new HashSet<>();
            for (int[] direction : directions) {
                int nextX = zeroNode.x + direction[0];
                int nextY = zeroNode.y + direction[1];
                if ((nextX >= 0) && (nextX < n) && (nextY >= 0) && (nextY < n) && (grid[nextX][nextY] == 2) && (!existingUnion.contains(disjointUnion.find(nextX * n + nextY)))) {
                    currentSize += disjointUnion.getSize(nextX * n + nextY);
                    existingUnion.add(disjointUnion.find(nextX * n + nextY));
                }
            }
            result = Math.max(result, currentSize);
        }
        if (result == 0) {
            return disjointUnion.getSize(0);
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        MakingALargeIsland solution = new MakingALargeIsland();
        int[][] grid = new int[][] {{1, 1}, {1, 0}};
        System.out.println(solution.largestIsland(grid));
    }
}

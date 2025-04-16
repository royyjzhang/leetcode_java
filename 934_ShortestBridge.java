import java.util.ArrayDeque;

public class ShortestBridge {
    class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class BridgeLength {
        Position position;
        int distance;
        public BridgeLength(Position position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }

    public int shortestBridge(int[][] grid) {
        ArrayDeque<Position> findIslandQueue = new ArrayDeque<>();
        ArrayDeque<BridgeLength> buildBridgeQueue = new ArrayDeque<>();
        boolean foundOneIsland = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    foundOneIsland = true;
                    findIslandQueue.addLast(new Position(i, j));
                    while (!findIslandQueue.isEmpty()) {
                        Position current = findIslandQueue.removeFirst();
                        grid[i][j] = 2;
                        boolean onEdge = false;
                        if (current.x > 0) {
                            if (grid[current.x - 1][current.y] == 1) {
                                findIslandQueue.addLast(new Position(current.x - 1, current.y));
                                grid[current.x - 1][current.y] = 2;
                            } else if (grid[current.x - 1][current.y] == 0){
                                onEdge = true;
                            }
                        }
                        if (current.x < grid.length - 1) {
                            if (grid[current.x + 1][current.y] == 1) {
                                findIslandQueue.addLast(new Position(current.x + 1, current.y));
                                grid[current.x + 1][current.y] = 2;
                            } else if (grid[current.x + 1][current.y] == 0){
                                onEdge = true;
                            }
                        }
                        if (current.y > 0) {
                            if (grid[current.x][current.y - 1] == 1) {
                                findIslandQueue.addLast(new Position(current.x, current.y - 1));
                                grid[current.x][current.y - 1] = 2;
                            } else if (grid[current.x][current.y - 1] == 0){
                                onEdge = true;
                            }
                        }
                        if (current.y < grid[0].length - 1) {
                            if (grid[current.x][current.y + 1] == 1) {
                                findIslandQueue.addLast(new Position(current.x, current.y + 1));
                                grid[current.x][current.y + 1] = 2;
                            } else if (grid[current.x][current.y + 1] == 0){
                                onEdge = true;
                            }
                        }
                        if (onEdge) {
                            buildBridgeQueue.addLast(new BridgeLength(current, 0));
                        }
                    }
                }
                if (foundOneIsland) {
                    break;
                }
            }
            if (foundOneIsland) {
                break;
            }
        }
        while (!buildBridgeQueue.isEmpty()) {
            BridgeLength current = buildBridgeQueue.removeFirst();
            if (current.position.x > 0) {
                if (grid[current.position.x - 1][current.position.y] == 0) {
                    buildBridgeQueue.addLast(new BridgeLength(new Position(current.position.x - 1, current.position.y), current.distance + 1));
                    grid[current.position.x - 1][current.position.y] = 3;
                } else if (grid[current.position.x - 1][current.position.y] == 1){
                    return current.distance;
                }
            }
            if (current.position.x < grid.length - 1) {
                if (grid[current.position.x + 1][current.position.y] == 0) {
                    buildBridgeQueue.addLast(new BridgeLength(new Position(current.position.x + 1, current.position.y), current.distance + 1));
                    grid[current.position.x + 1][current.position.y] = 3;
                } else if (grid[current.position.x + 1][current.position.y] == 1){
                    return current.distance;
                }
            }
            if (current.position.y > 0) {
                if (grid[current.position.x][current.position.y - 1] == 0) {
                    buildBridgeQueue.addLast(new BridgeLength(new Position(current.position.x, current.position.y - 1), current.distance + 1));
                    grid[current.position.x][current.position.y - 1] = 3;
                } else if (grid[current.position.x][current.position.y - 1] == 1){
                    return current.distance;
                }
            }
            if (current.position.y < grid[0].length - 1) {
                if (grid[current.position.x][current.position.y + 1] == 0) {
                    buildBridgeQueue.addLast(new BridgeLength(new Position(current.position.x, current.position.y + 1), current.distance + 1));
                    grid[current.position.x][current.position.y + 1] = 3;
                } else if (grid[current.position.x][current.position.y + 1] == 1){
                    return current.distance;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestBridge solution  = new ShortestBridge();
        int[][] grid = new int[][] {{0, 1}, {1, 0}};
        System.out.println(solution.shortestBridge(grid));
    }
}

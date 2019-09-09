package leetcode.queue_stack;

/**
 * This is DFS version of Number of Islands
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isIslandCell(grid, i, j) && isNotVisited(visited, i, j)) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isIslandCell(char[][] grid, int row, int col) {
        return grid[row][col] == '1';
    }

    private boolean isNotVisited(boolean[][] visited, int row, int col) {
        return !visited[row][col];
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        // down, up, right, left
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        //mark this cell as visited
        visited[row][col] = true;

        for (int dir = 0; dir < 4; dir++) {
            if (isSafe(grid, row + dirs[dir][0], col + dirs[dir][1], visited)) {
                dfs(grid, row + dirs[dir][0], col + dirs[dir][1], visited);
            }
        }

    }

    private boolean isSafe(char[][] grid, int row, int col, boolean[][] visited) {
        return (row >= 0)
                && (col >= 0)
                && (row < grid.length)
                && (col < grid[0].length)
                && (grid[row][col] == '1' && !visited[row][col]);
    }
}

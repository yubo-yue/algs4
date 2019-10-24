package leetcode.queue_stack;

public class NumberOfIsland_2 {
    private void dfs(char[][] island, int r, int c) {
        int nr = island.length;
        int nc = island[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || island[r][c] == '0') {
            return;
        }

        island[r][c] = '0'; //the island cell visted.
        dfs(island, r + 1, c);
        dfs(island, r - 1, c);
        dfs(island, r, c + 1);
        dfs(island, r, c - 1);
    }

    public int numIslands(char[][] grids) {
        if (grids == null || grids.length == 0) {
            return 0;
        }

        int nr = grids.length;
        int nc = grids[0].length;
        int numIslands = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grids[i][j] == '1') {
                    numIslands++;
                    dfs(grids, i, j);
                }
            }
        }
        return numIslands;
    }
}

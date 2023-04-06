class Solution {
    public int closedIsland(int[][] grid) {
        // 1. Find all the islands
        // 2. For each island, check if it is closed
        // 3. If it is closed, increment the counter

        int row = grid.length, col = grid[0].length;
        int count = 0;
        for( int i = 0; i < row; i++ ) {
            for( int j = 0; j < col; j++ ) {
                if( grid[i][j] == 0 ) {
                    if( dfs(grid, i, j) ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Return true if the island is closed
    private boolean dfs(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        if( i < 0 || i >= row || j < 0 || j >= col ) {
            return false;
        }
        if( grid[i][j] == 1 ) {
            return true;
        }
        grid[i][j] = 1;
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        return left && right && up && down;
    }
}
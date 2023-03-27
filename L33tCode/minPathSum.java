class Solution {
    public int minPathSum(int[][] grid) {
        // Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
        // Note: You can only move either down or right at any point in time.

        // create a new array to store the minimum path sum
        int[][] minPath = new int[grid.length][grid[0].length];
        // initialize the first row and column
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            minPath[0][j] = minPath[0][j - 1] + grid[0][j];
        }
        // calculate the minimum path sum
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
            }
        }
        return minPath[grid.length - 1][grid[0].length - 1];
    }
}
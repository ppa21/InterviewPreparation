/*
    * DFS and memoization

    * Time Complexity  = O(nm); size of matrix
    * Space Complexity = O(nm); size of matrix/dp
*/
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int longestPath = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int longest = dfs(matrix, dp, i, j);
                longestPath = Math.max(longestPath, longest);
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        // check if we've visited this position before
        // MEMOIZATION
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        // else we have not been at this position before
        int longestPath = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            // invalid
            // matrix[x][y] <= matrix[i][j] 
                // INVALID 
                // we want STRICTLY increasing path
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            int longest = dfs(matrix, dp, x, y);
            longestPath = Math.max(longestPath, longest);
        }

        dp[i][j] = longestPath + 1; // + 1 because we include the current position

        return dp[i][j];
    }
}

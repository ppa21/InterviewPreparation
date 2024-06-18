class Solution {
    /*
        * Time Complexity  = O(nm); n = grid.length; m = grid[i].length; AKA size of matrix
        * Space Complexity = O(nm)
    */
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int distanceFromGate) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] < distanceFromGate) {
            return;
        }

        grid[i][j] = distanceFromGate;

        dfs(grid, i - 1, j, distanceFromGate + 1);
        dfs(grid, i + 1, j, distanceFromGate + 1);
        dfs(grid, i, j - 1, distanceFromGate + 1);
        dfs(grid, i, j + 1, distanceFromGate + 1);
    }
}

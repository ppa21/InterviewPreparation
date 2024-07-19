class Solution {
    /*
            * Time Complexity: O(MN)
                                * M = number of rows
                                * N = number of cols
            * Space Complexity: O(MN)
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();

        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // top AND bottom
        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, heights[0][c], pacific);
            dfs(heights, rows - 1, c, heights[rows - 1][c], atlantic);
        }

        // left AND RIGHT
        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, heights[r][0], pacific);
            dfs(heights, r, cols - 1, heights[r][cols - 1], atlantic);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] ocean) {
        if(r < 0 || c < 0 || r > heights.length - 1 || c > heights[r].length - 1 || heights[r][c] < prevHeight || ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        dfs(heights, r - 1, c, heights[r][c], ocean);
        dfs(heights, r + 1, c, heights[r][c], ocean);
        dfs(heights, r, c - 1, heights[r][c], ocean);
        dfs(heights, r, c + 1, heights[r][c], ocean);
    }
}
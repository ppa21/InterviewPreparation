/*
         * time complexity  = O(n^2)
         * space complexity = O(n^2)
 
         * VARIANT: What if you had to return a single path? Note it's not necessarily the shortest. dfs > bfs
 */
class Solution {
    private int[][] directions = {{-1, 0}, {-1, 1}, {0, 1},
                                  {1, 1}, {1, 0}, {1, -1},
                                  {0, -1}, {-1, -1}};
    
    public List<List<Integer>> pathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return new ArrayList<>();
        }
        
        List<int[]> path = new ArrayList<>();
        dfs(grid, path, 0, 0);
        
        // convert path to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (int[] cell : path) {
            result.add(Arrays.asList(cell[0], cell[1]));
        }
        return result;
    }

    private boolean dfs(int[][] grid, List<int[]> path, int i, int j) {
        grid[i][j] = 1;
        path.add(new int[]{i, j});
        
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= grid.length) {
                continue;
            }
            if (y < 0 || y >= grid[0].length) {
                continue;
            }
            if (grid[x][y] == 1) {
                continue;
            }
            
            if (dfs(grid, path, x, y)) {
                return true;
            }
        }
        
        path.remove(path.size() - 1); // backtrack
        return false;
    }
}

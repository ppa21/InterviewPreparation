/*
        * Problem: You are given an m x n grid where:
            * 0 represents empty land that you can pass by freely
            * 1 represents a building that you cannot pass through
            * 2 represents an obstacle that you cannot pass through
        * You want to build a house on an empty land that reaches all buildings 
          in the shortest total travel distance.
          Return the minimum total distance. If it's impossible to build such a mailbox, return -1.
 
        * Time Complexity: O(B × m × n) where B = number of buildings, m×n = grid dimensions
            * We run BFS from each building, and each BFS visits at most O(m×n) cells
            * In worst case where every cell is a building: O(m²×n²)
        * Space Complexity: O(m × n)
            * matrix[m][n][2] for storing distances and reachability counts
            * BFS queue can hold at most O(m×n) cells
 */
class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // For each cell [i][j], we track 2 numbers:
        // [0] = sum of steps from all buildings to this cell
        // [1] = how many buildings can actually reach this cell
        int[][][] matrix = new int[m][n][2];
        
        int buildingCount = 0;
        
        // Run BFS from each building to calculate distances
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, matrix, i, j, buildingCount);
                    buildingCount++;
                }
            }
        }
        
        int minTotalSteps = Integer.MAX_VALUE;
        
        // Find cell with minimum total steps that all buildings can reach
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j][1] == buildingCount) { // Reachable by all buildings
                    minTotalSteps = Math.min(minTotalSteps, matrix[i][j][0]);
                }
            }
        }
        
        return minTotalSteps == Integer.MAX_VALUE ? -1 : minTotalSteps;
    }
    
    private void bfs(int[][] grid, int[][][] matrix, int i, int j, int buildingCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 0}); // {row, col, steps from building}
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];
            
            // Explore all 4 directions
            for (int[] dir : directions) {
                int x = row + dir[0];
                int y = col + dir[1];
                
                if (x >= 0 && x < grid.length && 
                    y >= 0 && y < grid[0].length &&
                    matrix[x][y][1] == buildingCount &&         // Only visit if reachable by all previous buildings
                    grid[x][y] == 0) {                          // Must be empty land
                    matrix[x][y][0] += steps + 1;               // Add walking steps
                    matrix[x][y][1] = buildingCount + 1;        // Mark as visited by this building
                    queue.offer(new int[]{x, y, steps + 1});
                }
            }
        }
    }
}

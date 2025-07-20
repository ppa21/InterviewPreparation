/*
        * time complexity  = O(n^2)
        * space complexity = O(n^2)
*/
class Solution {
    private int[][] directions = {{-1, 0}, {-1, 1}, {0, 1},
                                  {1, 1}, {1, 0}, {1, -1},
                                  {0, -1}, {-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // if the starting/ending point have 1, we can't even start/end
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        
        grid[0][0] = 1; // we start at {0, 0} ----> mark as visited with 1
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // row, col, steps
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int s = curr[2];
            
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return s;
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

                grid[x][y] = 1;
                q.offer(new int[]{x, y, s + 1});
            }
        }
        
        return -1;
    }
}

/*
         * time complexity  = O(n^3)
         * space complexity = O(n^3)  

         * VARIANT: What happens if you have to return the path of a shortest path?
 */
class Solution {
    private int[][] directions = {{-1, 0}, {-1, 1}, {0, 1},
                                  {1, 1}, {1, 0}, {1, -1},
                                  {0, -1}, {-1, -1}};
    
    public List<List<Integer>> shortestPathBinaryMatrix(int[][] grid) {
        // if the starting/ending point have 1, we can't even start/end
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return new ArrayList<>();
        }
        
        grid[0][0] = 1; // we start at {0, 0} ----> mark as visited with 1
        Queue<Object[]> q = new LinkedList<>();
        List<int[]> initialPath = new ArrayList<>();
        initialPath.add(new int[]{0, 0});
        q.offer(new Object[]{0, 0, initialPath}); // row, col, path
        
        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            int i = (int) curr[0];
            int j = (int) curr[1];
            List<int[]> path = (List<int[]>) curr[2];
            
            // end?
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                // convert path to List<List<Integer>>
                List<List<Integer>> result = new ArrayList<>();
                for (int[] cell : path) {
                    result.add(Arrays.asList(cell[0], cell[1]));
                }
                return result;
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
                
                List<int[]> pathCopy = new ArrayList<>(path);
                pathCopy.add(new int[]{x, y});
                q.offer(new Object[]{x, y, pathCopy});
            }
        }
        
        return new ArrayList<>(); // no path found
    }
}

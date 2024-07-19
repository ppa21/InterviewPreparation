class Solution {
    /*
        * Time Complexity  = O(nm); n = rows; m = cols
        * Space Complexity = O(nm); all rows and columns could be added to the queue
    */
    public int orangesRotting(int[][] grid) {
        // Initialize a queue to keep track of rotten oranges
        Queue<int[]> rotten = new LinkedList<>();
        int freshCount = 0; // Count of fresh oranges
        
        // Go through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If the orange is rotten, add its coordinates to the queue
                if (grid[i][j] == 2) {
                    rotten.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) { // If the orange is fresh, increase the fresh count
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges, no time is needed
        if (freshCount == 0) { 
            return 0;
        }
        
        int minutes = 0; // Time in minutes to rot all oranges
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Directions array to help move up, down, left, right
        
        // Process until all reachable fresh oranges are rotten
        while (!rotten.isEmpty()) {
            minutes++; // Increment the time after processing this level
            int size = rotten.size(); // Number of rotten oranges to process at this minute

            for (int i = 0; i < size; i++) { // Process all rotten oranges for this minute
                int[] point = rotten.poll(); // Get the position of the current rotten orange

                // Check all four directions around the rotten orange
                for (int[] direction : directions) {
                    int x = point[0] + direction[0]; // New x-coordinate
                    int y = point[1] + direction[1]; // New y-coordinate
                    
                    // If the new position is within the grid and has a fresh orange
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2; // Rot the fresh orange
                        freshCount--; // Decrease the count of fresh oranges
                        rotten.offer(new int[]{x, y}); // Add the new rotten orange to the queue
                    }
                }
            }
        }
        
        // If there are still fresh oranges left, return -1, otherwise return the time taken
        return freshCount == 0 ? minutes - 1 : -1;
    }
}

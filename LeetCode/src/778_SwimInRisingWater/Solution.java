/*
    * Time Complexity  = O((n^2)*log(n)); n = dimensions of the matrix
    * Space Complexity = O(n^2)
*/
class Solution {
    public int swimInWater(int[][] grid) {
        
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Directions array to help move in the grid (up, down, left, right)
        int length = grid.length;

        // If the grid is 1x1, no need to swim
        if (length == 1) {
            return 0;
        }

        boolean[][] seen = new boolean[length][length]; // 'seen' array to keep track of visited cells
        seen[0][0] = true;  // Mark the starting cell as visited

        /*
            * Min heap to determine the next cell to visit based on elevation
            * int[] = (E, x, y); E = elevation at the current cell; x = x coordinate of the current cell; y = y coordinate of the current cell
        */
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[] { grid[0][0], 0, 0 });    // Add the starting cell to the min heap

        // 'result' will store the minimum time to reach the end
        int result = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            /* 
                * Update 'result' with the maximum elevation we've encountered
                * Compare current cell's elevation VS. result which stores max until reaching to the current cell
            */
            result = Math.max(result, curr[0]);

            // If we've reached the bottom right cell, exit the loop
            if (curr[1] == length - 1 && curr[2] == length - 1) {
                break;
            }

            // Explore all possible directions from the current cell
            for (int[] dir : dirs) {
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];

                // Check if the new cell is within bounds and not yet visited
                if (x < 0 || x >= length || y < 0 || y >= length || seen[x][y]) {
                    continue;
                }

                // Add the new cell to the min heap and mark it as visited
                minHeap.add(new int[] { grid[x][y], x, y });
                seen[x][y] = true;
            }
        }

        // Return the minimum time required to reach the end
        return result;
    }
}

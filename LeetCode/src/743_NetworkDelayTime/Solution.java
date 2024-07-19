class Solution {
    /*
        * Time Complexity  = O(nt); n = number of nodes; t = number of edges in the input (times array)
        * Space Complexity = O(n); n = number of nodes in paths array
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];   // array to hold shortest time to reach each node from starting node 'k'
        Arrays.fill(paths, Integer.MAX_VALUE);

        paths[k - 1] = 0;   // starting node's time to itself is always 0

        // Repeat the process 'n' times to ensure all shortest paths are found
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.copyOf(paths, paths.length);    //'temp' array is a temporary snapshot of 'paths' to compare with updated times

            // Loop through all given times to update the 'temp' array with new shortest times
            for (int j = 0; j < times.length; j++) {
                int source = times[j][0]; 
                int target = times[j][1]; 
                int time = times[j][2];

                // if the source path hasn't been visited yet, skip this path
                if (temp[source - 1] == Integer.MAX_VALUE) {
                    continue;
                }

                // If the source node's time is known and the target can be reached quicker through the source
                if (temp[source - 1] + time < temp[target - 1]) {
                    // Update the target node's time in 'temp'
                    temp[target - 1] = temp[source - 1] + time;
                }
            }

            // After checking all routes, update 'paths' with the new shortest times
            paths = temp;
        }

        // 'result' will hold the longest shortest time to any node
        int result = Integer.MIN_VALUE;

        // Find the maximum time it takes to reach any node
        for (int i = 0; i < n; i++) {
            // If any node is unreachable, return -1
            if (paths[i] == Integer.MAX_VALUE) {
                return -1;
            }
            // Update 'result' with the maximum time found
            // This is the longest time among the shortest paths to each node
            result = Math.max(result, paths[i]);
        }

        return result;
    }
}

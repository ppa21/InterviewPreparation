class Solution {
    /*
     * The algorithm = 
        * 1. Sort the intervals by their start time.
        * 2. Track the original indices of the queries to return results in the correct order.
        * 3. Sort the queries by their values.
        * 4. Use a min-heap to store intervals based on their size, ensuring the smallest interval that can cover a query is easily accessible.
        * 5. For each query, add all intervals that start before or at the query time to the heap.
        * 6. Remove intervals from the heap that end before the query time.
        * 7. The top of the heap now contains the smallest interval that can cover the query.
        * 8. Store the result for each query.

     * Time Complexity  = O(n log n + m log m); n = number of intervals; m = number of queries
     * Space Complexity = O(n + m); n = size of priority queue; m = size of result array
     */

    public int[] minInterval(int[][] intervals, int[] queries) {
        int numIntervals = intervals.length;
        int numQueries = queries.length;

        // Step 1: Sort intervals by their start time
        // Sorting intervals to process them in chronological order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Prepare result array and track original indices of queries
        int[] result = new int[numQueries]; // Array to store results for each query
        int[][] indexedQueries = new int[numQueries][2]; // Array to store query values and their original indices

        // Populate indexedQueries array with query values and original indices
        for (int i = 0; i < numQueries; i++) {
            indexedQueries[i][0] = queries[i]; // Store query value
            indexedQueries[i][1] = i;          // Store original index
        }

        // Step 3: Sort queries by their value
        // Sorting queries to process them in ascending order of their values
        Arrays.sort(indexedQueries, (a, b) -> a[0] - b[0]);

        // Step 4: Min-heap to store intervals based on their size (end - start + 1)
        // PriorityQueue to keep track of the smallest interval that can cover a query
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[1] - a[0] + 1) - (b[1] - b[0] + 1)
        );

        // Step 5: Index to track the current interval being considered
        int idx = 0;

        // Step 5: Process each query in sorted order
        for (int i = 0; i < numQueries; i++) {
            int queryValue = indexedQueries[i][0]; // Get the query value
            int queryIndex = indexedQueries[i][1]; // Get the original index of the query

            // Step 5: Add all intervals that start before or at the current query to the heap
            while (idx < numIntervals && intervals[idx][0] <= queryValue) {
                minHeap.offer(intervals[idx]);
                idx++;
            }

            // Step 6: Remove intervals from the heap that end before the current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryValue) {
                minHeap.poll();
            }

            // Step 7: If the heap is not empty, the smallest interval that covers the query is at the top
            if (!minHeap.isEmpty()) {
                int[] smallestInterval = minHeap.peek();
                result[queryIndex] = smallestInterval[1] - smallestInterval[0] + 1;
            } else {
                result[queryIndex] = -1; // No interval covers the query
            }
        }

        // Step 8: Return the result array containing the smallest intervals for each query
        return result;
    }
}

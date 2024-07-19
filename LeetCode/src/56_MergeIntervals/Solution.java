class Solution {
    public int[][] merge(int[][] intervals) {
        // intervals = [[1,3],[2,6],[8,10],[15,18]]

        // Sort by start time
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> output = new ArrayList();
        int[] currentInterval = intervals[0];       // Get the first interval from int[][] intervals. currentInterval = [1, 3]
        output.add(currentInterval);

        for(int[] interval : intervals) {
            int currentStart = currentInterval[0];  // currentStart = 1
            int currentEnd = currentInterval[1];    // currentEnd = 3
            int nextStart = interval[0];            // nextStart = 1 ---> second iteration ---> 2
            int nextEnd = interval[1];              // nextEnd = 3 ---> second iteration ---> 6

            if(currentEnd >= nextStart) {
                /*
                 * Overlap
                 * currentInterval[1] = 3 ---> second iteration ---> 6
                 * Don't need to re-add currentInterval even after the update
                 * Update will automatically propogate into List<int[]> output
                 */
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                /*
                 * No overlap
                 * Since there's no overlap ---> currentInterval will need to be updated to int[] interval
                 * Then, add the new currentInteval to List<int[]> output

                 * Repeat the process for all int[] interval in int[][] intervals
                 */
                currentInterval = interval;
                output.add(currentInterval);
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
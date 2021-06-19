class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int indexOfLastIntervalIncluded = 0;
        int numberOfIntervalsRemoved = 0;

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[indexOfLastIntervalIncluded][1] > intervals[i][0]) {
                /*
                 * OVERLAP
                 * Either intervals[indexOfLastIntervalIncluded] OR intervals[i] to be REMOVED
                 * REMOVE the one that ends at a later time
                 * Eg.
                 * intervals[indexOfLastIntervalIncluded][1] > intervals[i][1]
                 * REMOVE the interval at indexOfLastIntervalIncluded and update it to i
                 * indexOfLastIntervalIncluded = i
                 */
                numberOfIntervalsRemoved++;
                if(intervals[indexOfLastIntervalIncluded][1] > intervals[i][1]) {
                    indexOfLastIntervalIncluded = i;
                }
            } else {
                // NO OVERLAP
                indexOfLastIntervalIncluded = i;
            }
        }

        return numberOfIntervalsRemoved;
    }
}
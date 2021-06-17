class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int[][] intervals = ALREADY SORTED
        // intervals = [[1, 3], [6, 9]]     newInterval = [2, 5]

        List<int[]> output = new ArrayList();

        for(int[] interval : intervals) {
            /*
                Iteration 1:
                    * ELSE:
                        * newInterval = [2, 5] ---> [1, 5]

                Iteration 2:
                    * ELSE IF condition
                        * output.add(newInterval) ---> output = [[1, 5]]
                        * newInterval = [6, 9]

                NOTE: Loop EXITED, but interval [6, 9] is NOT ADDED to output yet.
                      So, that's why we have output.add(newInterval) outside of the loop in LINE 33
             */
            if(interval[1] < newInterval[0]) {
                output.add(interval);
            } else if(newInterval[1] < interval[0]) {
                output.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        output.add(newInterval);

        return output.toArray(new int[output.size()][]);
    }
}
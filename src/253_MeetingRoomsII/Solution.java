/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        /*
                * Using PriorityQueue because everything in it is sorted in ascending order
                    * Eg: p = [2, 3, 5, 8]
                * PriorityQueue will hold END TIMES of schedules
                * If the next schedule's END TIME doesn't conflict (so NO CONFLICT) with any other END TIMES in p:
                    * We can remove END TIME that's at the top
                        * DON'T NEED TO OPEN A NEW ROOM SINCE THE ONE REMOVED FROM TOP WILL END BEFORE THE NEW ONE STARTS
         */
        PriorityQueue<Integer> p = new PriorityQueue();

        for(Interval next : intervals) {
            if(p.isEmpty()) {
                p.add(next.end);
                continue;
            }

            // NO CONFLICT
            if(p.peek() <= next.start) {
                // REMOVE FROM TOP
                p.remove();
            }

            p.add(next.end);
        }

        return p.size();
    }
}
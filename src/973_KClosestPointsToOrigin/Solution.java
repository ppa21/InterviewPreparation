/*
    * Time Complexity  = O(nlogk)
        * maxHeap size = k;
            * maxHeap.remove() = logn --> logk 
                * since it will only store k values at a time
                    * BETTER 
    * Space Complexity = O(k); points = O(n) but that's input so it doesn't count
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
            * points = [[1, 3], [-2, 2]] --> 1^2 + 3^2 = 10, (-2)^2 + 2^2 = 8 --> DISTANCE = [10, 8]
            * maxHeap adds each point and stores it in DESCENDING ORDER based on the DISTANCE
        */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])
            )
        );

        for (int[] point : points) {
            maxHeap.add(point);

            // only store k values = logn --> logk
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] curr = maxHeap.remove();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }

        return result;
    }
}

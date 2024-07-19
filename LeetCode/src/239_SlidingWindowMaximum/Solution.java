class Solution {
    /*
        * MONOTONICALLY DECREASING QUEUE
        * time complexity  = O(n)
        * space complexity = O(n)

        nums = [8, 7, 6, 9], k = 2

        window = [8, 7]
        deque = [8, 7]; FIRST = 8; LAST = 7
            7 > 8? NO, so add 7; only REMOVE SMALLER elements
        output = [8]

        window = [7, 6]
        deque = [8, 7] -> [7, 6]
            8 NO LONGER in window so REMOVE 8 from deque
            6 > 7? NO, so add 6; only REMOVE SMALLER elements
        output = [8, 7]

        window = [6, 9]
        deque = [7, 6] -> [9]
            7 NO LONGER in window so REMOVE 7 from deque
            9 > 6? YES, REMOVE from TOP/RIGHTMOST position of deque
            then, ADD 9
        output = [8, 7, 9]
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];              // number of windows
        Deque<Integer> windows = new LinkedList<>();    // stores indices

        for (int i = 0; i < n; i++) {
            // remove indices that are out of bound
            if (!windows.isEmpty() && windows.peekFirst() <= i - k) {
                windows.pollFirst();
            }

            // remove indices whose corresponding values are less than nums[i]
            // i.e. REMOVING 6 from the LAST iteration
            while (!windows.isEmpty() && nums[i] > nums[windows.peekLast()]) {
                windows.pollLast();
            }

            // add nums[i]
            windows.offer(i);

            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[windows.peekFirst()];
            }
        }

        return result;
    }
}
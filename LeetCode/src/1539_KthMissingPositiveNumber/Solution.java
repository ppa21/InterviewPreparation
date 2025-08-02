/*
    * Time Complexity  = O(logn)
    * Space Complexity = O(1)

    * formula
        * arr[middle] - 1 - middle
        * count of missing numbers up until index middle
           * starting from 1
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int missing = arr[middle] - 1 - middle;

            if (k > missing) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // left = we've seen 'left' numbers from arr from left
        // k    = we want kth missing number
        return left + k;
    }
}

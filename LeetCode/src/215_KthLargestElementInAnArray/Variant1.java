/*
    * Time Complexity  = O(nlogk)
    * Space Complexity = O(k)

    * VARIANT: What if you had to return the Kth + 1 largest number in an integer array?
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k + 1 > nums.length) {
            throw new IllegalArgumentException("k + 1 can't exceed nums.length");
        }
        k = k + 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);

            if (minHeap.size() > k) {
                minHeap.remove();       
            }
        }

        return minHeap.peek();
    }
}

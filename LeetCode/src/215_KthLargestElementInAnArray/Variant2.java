/*
    * Time Complexity  = O(nlogk)
    * Space Complexity = O(k)

    * VARIANT: What if you had to find the Kth smallest number in an integer array?
*/
class Solution {
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int n : nums) {
            maxHeap.add(n);

            if (maxHeap.size() > k) {
                maxHeap.poll();       
            }
        }

        return maxHeap.peek();
    }
}

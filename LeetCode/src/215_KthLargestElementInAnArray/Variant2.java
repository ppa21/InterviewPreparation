/*
    * Time Complexity  = O(nlogk)
        * maxHeap size = k;
            * maxHeap.remove() = logn --> logk 
                * since it will only store k values at a time
                    * BETTER 
    * Space Complexity = O(k); maxHeap only maintains k elements at a time

    * VARIANT: What if you had to find the Kth smallest number in an integer array?
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int n : nums) {
            maxHeap.add(n); // add everything in maxHeap 

            if (maxHeap.size() > k) {   // if maxHeap.size() is GREATER than k
                maxHeap.remove();       
            }
        }

        return maxHeap.remove();    // kth smallest element will be the first element
    }
}

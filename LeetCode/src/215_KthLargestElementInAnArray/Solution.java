/*
    * Time Complexity  = O(nlogk)
        * minHeap size = k;
            * minHeap.remove() = logn --> logk 
                * since it will only store k values at a time
                    * BETTER 
    * Space Complexity = O(k); minHeap only maintains k elements at a time
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n); // add everything in minHeap 

            if (minHeap.size() > k) {   // if minHeap.size() is GREATER than k
                // remove the SMALLEST ELEMENT (which happens to be the FIRST ELEMENT cuz minHeap) until there are ONLY K ELEMENTS
                minHeap.remove();       
            }
        }

        return minHeap.remove();    // kth largest element will be the first element
    }
}

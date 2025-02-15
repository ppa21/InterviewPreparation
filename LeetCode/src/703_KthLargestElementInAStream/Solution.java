/*
    * Time Complexity:
        * Constructor (KthLargest(int k, int[] nums)): O(n * log k)
        * add(int val) method: O(log k) (average case), O(1) (worst case)
    * Space Complexity: O(k)
*/
class KthLargest {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {   // ex: if your high score (val) is greater than your lowest high score (minHeap.peek()) and you can only keep k high scores, remove your lowest high score (minHeap.poll())
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/*
    * Time Complexity  = O(nlogn)
    * Space Complexity = O(n)
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();

            if (stone1 != stone2) {
                maxHeap.add(Math.abs(stone2 - stone1));
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.remove();
    }
}

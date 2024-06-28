class Solution {
    /* 
        * Prim's Algorithm
        
        * Time Complexity  = O(N^2 log(N)); N = length of points; N^2 = finding distance between a currNode and every other node to pick the shortest distance; log(N) = Priority Queue
        * Space Complexity = O(N^2)
    */
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // INDEX 0 = edge weight; INDEX 1 = index of the current node
        minHeap.offer(new int[] { 0, 0 });

        Set<Integer> visited = new HashSet<>(); // so we don't visit a node twice (THIS CREATES A LOOP)
        int cost = 0;

        // When visited.size() == points.length meaning that all the nodes has been connected.
        while (visited.size() < points.length) {
            int[] arr = minHeap.poll();

            int weight = arr[0];
            int currNode = arr[1];

            if (visited.contains(currNode)) {
                continue;
            }

            visited.add(currNode);
            cost += weight;

            // visiting neighboring nodes in the frontier from currNode
            for (int nextNode = 0; nextNode < points.length; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight = Math.abs(points[nextNode][0] - points[currNode][0]) + Math.abs(points[nextNode][1] - points[currNode][1]);

                    minHeap.offer(new int[] { nextWeight, nextNode });
                }
            }
        }

        return cost;
    }
}

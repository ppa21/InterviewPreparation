class Solution {
    /*
            * Solution to 684. Redundant Connection
            
            * Another UNION-FIND algorithm question
                * SIMILAR TO:
                    * 323. Number of Connected Components in an Undirected Graph
            
            * Time Complexity: O(N + MlogN)
                * M = # of edges
                * N = # of nodes
            * Space Complexity: O(N)
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
      
        int[] parent = new int[n + 1];
        
        // Initialize each node's parent to itself
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            // Find the parents for both edges
            int parent1 = find(edge[0], parent);
            int parent2 = find(edge[1], parent);
            
            // If both nodes have the same parent, a cycle is detected
            if(parent1 == parent2) {
                // The current edge is redundant and should be removed
                return edge;
            }
            union(edge[0], edge[1], parent);
        }
        
        // If no redundant connection is found, return an empty array
        return new int[]{};
    }
    
    private void union(int edge1, int edge2, int[] parent) {
        int parent1 = find(edge1, parent);
        int parent2 = find(edge2, parent);
        parent[parent1] = parent2;
    }
    
    // Helper function to find the parent of an edge
    private int find(int edge, int[] parent) {
        // Path compression: update the node's parent to its root parent
        if(parent[edge] != edge) {
            parent[edge] = find(parent[edge], parent);
        }
        
        return parent[edge];
    }
}

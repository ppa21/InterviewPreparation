class Solution {
    /*
        * Another UNION-FIND algorithm question
        
        * Time Complexity  = O(n)
        * Space Complexity = O(n)
    */ 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        
        // Initialize each node's parent to itself
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int edge1 = edge[0];
            int edge2 = edge[1];
            
            // Find the parents for both edges
            int parent1 = find(edge1, parent);
            int parent2 = find(edge2, parent);
            
            // If both nodes have the same parent, a cycle is detected
            if (parent1 == parent2) {
                // The current edge is redundant and should be removed
                return edge;
            } else {
                // Union the two sets by updating the parent
                parent[parent1] = parent2;
            }
        }
        
        // If no redundant connection is found, return an empty array
        return new int[]{};
    }
    
    // Helper function to find the parent of a edge
    private int find(int edge, int[] parent) {
        // Path compression: update the node's parent to its root parent
        if (parent[edge] != edge) {
            parent[edge] = find(parent[edge], parent);
        }
        
        return parent[edge];
    }
}

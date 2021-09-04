public class Solution {
    /*
            * Time Complexity: O(E + V)
                * E = # of edges
                * V = # of vertices (nodes)
            * Space Complexity: O(E + V)
     */

    /*
            * RULES:
                * VALID TREE:
                    * NO loops
                    * NO disjoint nodes
     */

    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here

        if(n <= 0) {
            return true;
        }

        Map<Integer, List<Integer>> adj = new HashMap();        // adj matrix: node --> [list of neighbors]
        for(int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }

        // UNDIRECTED GRAPH: 5 -> 6 == 6 -> 5
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet();

        return dfs(0, -1, adj, visited) && n == visited.size();
    }

    private boolean dfs(int curr, int prev, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        // LOOP
        if(visited.contains(curr)) {
            return false;
        }

        visited.add(curr);

        for(int neighbor : adj.get(curr)) {
            if(neighbor == prev) {
                continue;
            }

            if(!dfs(neighbor, curr, adj, visited)) {
                return false;
            }
        }

        return true;
    }
}
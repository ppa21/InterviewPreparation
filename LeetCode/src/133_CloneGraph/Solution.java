/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*
        * Time Complexity: O(N)
            * N = number of nodes in the graph
            * DFS visits EVERY node ONCE
        * Space Complexity: O(N)
            * We are making a COPY of EVERY node in the graph
 */
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap();

        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node copy = new Node(node.val);
        map.put(node.val, copy);    // ---> EQUAL ---> map.put(copy.val, copy);

        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }
}
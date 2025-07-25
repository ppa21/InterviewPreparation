/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    
    // No parent field initially in this variant, it's inferred from the list of nodes
};
*/

/*
        * time complexity  = O(n)
        * space complexity = O(n)

        * VARIANT: What if you were given all the nodes as a part of a vector? 
          not given root node
          not given parent node in Node definition
*/
class Solution {
    public Node lowestCommonAncestor(List<Node> nodes, Node pStart, Node qStart) {
        // Build the child-to-parent map
        Map<Node, Node> childToParent = new HashMap<>();
        for (Node node : nodes) {
            if (node.left != null) {
                childToParent.put(node.left, node);
            }
            if (node.right != null) {
                childToParent.put(node.right, node);
            }
        }

        Node p = pStart;
        Node q = qStart;

        while (p != q) {
            // Move 'p' up the tree; if it reaches the 'root' (no parent in map), teleport to 'qStart' to equalize path lengths.
            if (childToParent.containsKey(p)) {
                p = childToParent.get(p);
            } else {
                p = qStart;
            }

            // Move 'q' up the tree; if it reaches the 'root' (no parent in map), teleport to 'pStart' to equalize path lengths.
            if (childToParent.containsKey(q)) {
                q = childToParent.get(q);
            } else {
                q = pStart;
            }
        }

        return p; // p == q
    }
}

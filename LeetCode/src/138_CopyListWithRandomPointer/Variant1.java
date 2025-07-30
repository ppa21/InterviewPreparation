/*
// Definition for a Node.
class Node {
    int val;
    Node left;
    Node right;
    Node random;
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.random = null;
    }
}
*/

/*
        * Time Complexity  = O(n)
        * Space Complexity = O(n)

	* Variant: What if you had to deep copy a binary tree, not a linked list?
*/
class Solution {
    public Node copyRandomBinaryTree(Node root) {
        HashMap<Node, Node> map = new HashMap<>(); // HashMap to store the mapping from original node to its copy
        
        // First pass: for each node in the original tree, create a copy and store the mapping
        deepCopy(root, map);
        
        // Second pass: for each node in the original tree, assign the random pointers for its copy
        copyRandom(root, map);
        
        return map.get(root);
    }
    
    private Node deepCopy(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }
            
        map.put(node, new Node(node.val));
        map.get(node).left = deepCopy(node.left, map);
        map.get(node).right = deepCopy(node.right, map);
        
        return map.get(node);
    }
    
    private void copyRandom(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return;
        }
            
        map.get(node).random = map.get(node.random);
        copyRandom(node.left, map);
        copyRandom(node.right, map);
    }
}

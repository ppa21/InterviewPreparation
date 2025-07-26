/*
        * time complexity  = O(N)
        * space complexity = O(H)

        * Variant: What if you were given an N-ary Tree as the input, no longer a binary tree?
*/
class Solution {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        List<Node> keyNodes = new ArrayList<>();
        for (Node child : root.children) {
            Node keyNode = lowestCommonAncestor(child, p, q);
            if (keyNode != null) {
                keyNodes.add(keyNode);
            }
        }
        
        if (keyNodes.size() == 2) {
            return root;
        } else if (keyNodes.size() == 1) {
            return keyNodes.get(0);
        } else {
            return null;
        }
    }
}

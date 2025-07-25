/*
// Definition for a Node.
class Node {
    public char val; -------- int -> char
    public Node left;
    public Node right;
    public Node parent;
};
*/

/*
        * time complexity  = O(n)
        * space complexity = O(1)

        * Variant: what if val type changes from INT to CHAR
*/
class Solution {
    public Node lowestCommonAncestor(Node pStart, Node qStart) {
        Node p = pStart;
        Node q = qStart;

        while (p != q) {
            if (p.parent != null) {
                p = p.parent;
            } else {
                p = qStart;
            }

            if (q.parent != null) {
                q = q.parent;
            } else {
                q = pStart;
            }
        }

        return q;
    }
}

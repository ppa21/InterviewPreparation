/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

/*
        * time complexity  = O(n)
        * space complexity = O(1)
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        // Case 1: Empty list -> single node pointing to itself
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        Node prev = head;
        Node curr = head.next;
        
        while (true) {
            // Case 2: Normal insertion - value fits between prev and curr in sorted order
            if (prev.val <= insertVal && insertVal <= curr.val) {
                break;
            }
            
            // Case 3: Wrap-around insertion - 1 -> 2 -> 3 (prev) -> 1 (curr)...
            if (prev.val > curr.val && (insertVal >= prev.val || insertVal <= curr.val)) {
                break;
            }
            
            // Move to next position
            prev = curr;
            curr = curr.next;
            
            // Case 4: Full circle traversed - all values are the same - 1 -> 1 -> 1...
            if (prev == head) {
                break;
            }
        }
        
        // Insert the new node between prev and curr
        prev.next = new Node(insertVal, curr);

        return head;
    }
}

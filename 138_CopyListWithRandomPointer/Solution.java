/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
        * Time Complexity  = O(n)
        * Space Complexity = O(n)
    */
    public Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>(); // HashMap to store the mapping from original node to its copy

        // First pass: for each node in the original list, create a copy and store the mapping
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        // Second pass: for each node in the original list, assign the next and random pointers for its copy
        while (cur != null) {
            map.get(cur).next = map.get(cur.next); 
            map.get(cur).random = map.get(cur.random); 
            cur = cur.next; 
        }

        return map.get(head);
    }
}

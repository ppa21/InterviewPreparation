/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
    * Time Complexity  = O(n)
    * Space Complexity = O(1)
*/
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head); // dummy node to act as the prev of the first node
        ListNode curr = head; 
        ListNode prev = dummy; // Node to keep track of the previous node
        ListNode temp = null; // Temporary node to help in swapping nodes
        int count = k; 

        while (curr != null) {
            if (count > 1) {
                // If there are still nodes left in the current group, swap the current node with the node after it
                // Store the node next to prev in temp
                temp = prev.next;
                // Make the node next to prev as the node next to curr
                prev.next = curr.next;
                // Make the node next to curr as the node next to the node next to curr
                curr.next = curr.next.next;
                // Make the node next to the node next to prev as temp
                prev.next.next = temp;

                // Decrease the counter
                count--; 
            } else {
                // If the current group is reversed, move to the next group
                prev = curr;
                curr = curr.next;

                // Check if there are enough nodes left for the next group
                ListNode end = curr;
                for (int i = 0; i < k; ++i) {
                    if (end == null) {
                        // If not enough nodes left, return the head of the reversed list
                        return dummy.next; 
                    }
                    end = end.next;
                }

                // Reset the counter for the next group
                count = k; 
            }
        }

        // Return the head of the reversed list
        return dummy.next; 
    }
}

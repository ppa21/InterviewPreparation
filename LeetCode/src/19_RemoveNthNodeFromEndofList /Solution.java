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
        * time complexity  = O(n); n = size of head
        * space complexity = O(1)
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode();
        result.next = head;

        ListNode slow = result;
        ListNode fast = result;

        // advances fast pointer so that the gap between fast and slow is n nodes apart
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move fast to the end and slow to the next element while maintaining the gap
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        /*
         * slow.next is the element to be removed; so point to the element to be
         * removed's next aka slow.next.next
         */
        slow.next = slow.next.next;

        return result.next;
    }
}

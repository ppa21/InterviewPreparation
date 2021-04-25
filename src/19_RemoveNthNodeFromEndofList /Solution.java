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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

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

        return dummy.next;
    }
}
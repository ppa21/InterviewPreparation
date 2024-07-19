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
    head = 1 -> 2 -> 3 -> 4 -> 5
        curr = 1 -> 2 -> 3 -> 4 -> 5
        prev = null

    line 36:
        tmp = 2 -> 3 -> 4 -> 5

    line 37:
        curr.next = null

    line 38:
        prev = 1

    line 39:
        curr = 2 -> 3 -> 4 -> 5

 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
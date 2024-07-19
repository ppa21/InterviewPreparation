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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // starting variables
        int v1 = 0;
        int v2 = 0;
        int carry = 0;
        int sum = 0;
        ListNode result = new ListNode();
        ListNode current = result;

        while(l1 != null || l2 != null) {
            /* if l1 is not null, extract the value from l1 and move the pointer for l1 to the next element;
             * otherwise, v1 is 0
             */
            if(l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else {
                v1 = 0;
            }

            /* if l2 is not null, extract the value from l2 and move the pointer for l2 to the next element;
             * otherwise, v2 is 0
             */
            if(l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            } else {
                v2 = 0;
            }

            sum = v1 + v2 + carry;

            // sum = 12; carry = 12 / 10 -> 1; sum = 12 % 10 -> 2;
            carry = sum / 10;
            sum = sum % 10;

            // sum = 2;
            ListNode temp = new ListNode(sum);
            current.next = temp;
            current = current.next;
        }

        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            current.next = temp;
        }

        return result.next;
    }
}
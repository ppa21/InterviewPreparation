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
    public void reorderList(ListNode head) {
        // head = 1 -> 2 -> 3 -> 4 -> 5 -> 6

        if(head == null || head.next == null) {
            return;
        }

        // split into 2 lists
        ListNode l1 = head;             // head of first half   -----> l1   = 1
        ListNode fast = head;           // tail of second half -----> fast = 6
        ListNode slow = head;           // head of second half -----> slow = 4
        ListNode prev = null;           // tail of first half   -----> prev = 3

        while(fast != null && fast.next != null)  {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
            SPLITS THE 2 LISTS

            * 1 -> 2 -> 3 -> null
            * 4 -> 5 -> 6 -> null
        */
        prev.next = null;

        /*
            * REVERSE THE SECOND HALF
                * 6 -> 5 -> 4 -> null;
        */
        ListNode l2 = reverse(slow);

        /*
            * MERGE L1 AND L2
                * l1 = head of the first half
                    * l1 = 1 -> 2 -> 3 -> null
                * l2 = head of the second half that's reversed
                    * l2 = 6 -> 5 -> 4 -> null
        */
        merge(l1, l2);
    }

    // solution to problem 206. Reverse Linked List
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode tmp = null;

        while(curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        // if l1 is null ---> NOTHING TO MERGE
        while(l1 != null) {
            // l1 = 1, l2 = 6
            ListNode l1Next = l1.next;      // 2
            ListNode l2Next = l2.next;      // 5

            l1.next = l2;                   // 1 -> 6

            if(l1Next == null) {
                break;
            }

            l2.next = l1Next;               // 2
            l1 = l1Next;                    // 2
            l2 = l2Next;                    // 5
        }
    }
}
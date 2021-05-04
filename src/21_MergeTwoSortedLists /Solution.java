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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode prev = curr;

        while(l1 != null && l2 != null) {
            /*
             First iteration:
                     .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                     .
                l2 = 2 -> 4 -> 6 -> x
                l1.val < l2.val:
                    curr.next = 1 from l1
                              .
                    l1 = 1 -> 2 -> 3 -> 5 -> x

             Second iteration:
                          .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                     .
                l2 = 2 -> 4 -> 6 -> x
                l1.val >= l2.val:
                    curr.next = 2 from l2
                              .
                    l2 = 2 -> 4 -> 6 -> x

             Third iteration:
                          .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                          .
                l2 = 2 -> 4 -> 6 -> x
                l1.val < l2.val:
                    curr.next = 2 from l1
                                   .
                    l1 = 1 -> 2 -> 3 -> 5 -> x

             Fourth iteration:
                               .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                          .
                l2 = 2 -> 4 -> 6 -> x
                l1.val < l2.val:
                    curr.next = 3 from l1
                                        .
                    l1 = 1 -> 2 -> 3 -> 5 -> x

             Fifth iteration:
                                    .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                          .
                l2 = 2 -> 4 -> 6 -> x
                l1.val >= l2.val:
                    curr.next = 4 from l2
                                   .
                    l2 = 2 -> 4 -> 6 -> x
             Sixth iteration:
                                    .
                l1 = 1 -> 2 -> 3 -> 5 -> x
                               .
                l2 = 2 -> 4 -> 6 -> x
                l1.val < l2.val:
                    curr.next = 5 from l1
                                             .
                    l1 = 1 -> 2 -> 3 -> 5 -> x

             Exits the loop because l1 == NULL
             */
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // From this example, l1 is null -> curr.next = 6 from l2
        curr.next = (l1 == null) ? l2 : l1;

        /*
         curr = -1 -> 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 6
         prev = curr -> prev.next = 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 6
         return prev.next
         */
        return prev.next;
    }
}
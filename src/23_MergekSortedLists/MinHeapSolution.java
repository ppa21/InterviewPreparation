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
    /*
            Runtime:            O(nmlog(nm))
            Space Complexity:   O(nm)

            where:
                * n = max # of lists
                * m = max # of nodes in a list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> p = new PriorityQueue();

        for(ListNode head : lists) {
            while(head != null) {
                p.add(head.val);
                head = head.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while(!p.isEmpty()) {
            dummy.next = new ListNode(p.remove());
            dummy = dummy.next;
        }

        return result.next;
    }
}
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
        Runtime:            O(nlog(k))
        Space Complexity:   O(k)

        where:
            * n = # of nodes we have when we're merging 2 lists together
                * n = l1.length + l2.length
            * log(k) = comes from recursive function mergeKLists
                * k = # of recursive calls we'll have
 */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        /*
                * lists = [2, 4, 6, 8, 10]
                    * length = 5
                    * Indexes:
                        * start = 0
                        * middle = 2
                        * end = 4
         */
        int middle = start + ((end - start) / 2);

        ListNode left = mergeKLists(lists, start, middle);              // start = 0, middle = 2
        ListNode right = mergeKLists(lists, middle + 1, end);     // start = middle + 1 ---> start = 3, end = 4

        return merge(left, right);
    }

    /*
            * The 2 functions above do DIVIDE & CONQUER
            * The function below does MERGE
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(l1 != null || l2 != null) {
            if(l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        return result.next;
    }
}
/*
        * time complexity  = O(n); n is the nth variable given to us
        * space complexity = O(1)

        * variant: what if you had to remove ith node from the beginning?
*/
class Solution {
    public ListNode removeIthFromBeginning(ListNode head, int n) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode curr = result;
        
        for(int i = 0; i < n; i++) {
            if(curr.next == null) {
                return result.next;
            }
            curr = curr.next;
        }
        
        if(curr.next == null) {
            return result.next;
        }
            
        curr.next = curr.next.next;
        return result.next;
    }
}

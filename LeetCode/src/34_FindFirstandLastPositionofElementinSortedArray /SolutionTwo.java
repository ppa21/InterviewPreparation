// O(n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != target) {
                continue;
            }

            /* Only goes in this if statement once.
               Then, first != -1 because we do first = i and index i can't be -1
             */
            if(first == -1) {
                first = i;
            }

            last = i;
        }

        if(first != -1) {
            int[] index = new int[2];
            index[0] = first;
            index[1] = last;

            return index;
        } else {
            return new int[]{-1, -1};
        }
    }
}
/**
        * Time Complexity:  O(k log n) where k is number of unique elements
        * Space Complexity: O(1) 

        * Variant: What if you had to return the number of unique elements in an integer array?
          Note this must be done in K LOG N time complexity (unless the input has all unique integers)
*/
class Solution {
    public int countUniqueElements(int[] nums) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            int target = nums[i];
            int left = i;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = ((right - left) / 2) + left;

                if (target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            count++;
            i = right + 1;
        }
        
        return count;
    }
}

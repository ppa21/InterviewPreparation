/*
        * Time  Complexity = O(n);
        * Space Complexity = O(1);

        * variant: What if you had to optimize the space complexity in the case you're only given positive integers in the array?
*/
class Solution {
    public boolean subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (right < nums.length) {
            sum += nums[right];
            
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            
            if (sum == k) {
                return true;
            }
            
            right++;
        }
        return false;
    }
}

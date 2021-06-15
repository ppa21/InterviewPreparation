class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        boolean[] dp = new boolean[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                dp[i] = true;
                goal = i;
            } else {
                dp[i] = false;
            }
        }

        return dp[0];
    }
}
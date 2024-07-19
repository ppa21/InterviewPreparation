class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= goal) {
//                System.out.println("i: " + i + ", nums[i]: " + nums[i] + ", i + nums[i]: " + (i + nums[i]) + ", goal: " + goal);
                goal = i;
            }
        }

        return goal == 0;
    }
}
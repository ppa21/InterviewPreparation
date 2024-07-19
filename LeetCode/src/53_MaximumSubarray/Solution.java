class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            /*
             Consider nums = [-2,1,-3,4,-1,2,1,-5,4] -> nums.length = 9
             max = -2
             sum = 0

             Iteration 1:
                sum is not < 0
                sum = -2
                max = -2

             Iteration 2:
                sum < 0
                    sum = 0
                sum = 1
                max = 1

             Iteration 3:
                sum is not < 0
                sum = -2
                max = 1

             Iteration 4:
                sum < 0
                    sum = 0
                sum = 4
                max = 4

             Iteration 5:
                sum is not < 0
                sum = 3
                max = 4

             Iteration 6:
                sum is not < 0
                sum = 5
                max = 5

             Iteration 7:
                sum is not < 0
                sum = 6
                max = 6

             Iteration 8:
                sum is not < 0
                sum = 1
                max = 6

             Iteration 9:
                sum is not < 0
                sum = 5
                max = 6

             Loop ends here because i will be 9 in the next iteration and 9 is not < nums.length
             */
            if(sum < 0) {
                sum = 0;
            }

            sum += nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}

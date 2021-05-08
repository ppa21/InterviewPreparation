class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            /*
             Consider nums = [1, 3, 3, 4] -> nums.length = 4

             Iteration 1:
                count = 0
                i = 1
                nums[0] != nums[i]:
                    count = 1
                    nums[1] = 3
                    nums = [1, 3, 3, 4]

             Iteration 2:
                count = 1
                i = 2
                nums[1] == nums[2]

             Iteration 3:
                count = 1
                i = 3
                nums[1] != nums[3]
                    count = 2
                    nums[2] = 4
                    nums = [1, 3, 4]

             Iteration 4 won't happen because i == 4 which is not < nums.length.
             But, count = 2 while the answer = 3.
             So, return count + 1
             */
            if(nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count + 1;
    }
}
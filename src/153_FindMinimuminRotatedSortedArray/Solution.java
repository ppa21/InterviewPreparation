class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        /*
              * EXCEPTION to BS: 
                  * This BS: left < right
                  * usual BS: left <= right
         */
        while(left < right) {
            // ideal way to find middle
            int middle = left + ((right - left) / 2);

            // nums = [3,4,5,1,2] -> run through below the function
            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        // return nums[left] OR nums[right]
        return nums[left];
    }
}

            /*
                nums = [3,4,5,1,2]

                Iteration 1:
                    left = 0
                    right = 4
                    middle = 2

                    nums[2] > nums[4] -> 5 > 2
                        left = 2 + 1 -> left = 3

                Iteration 2:
                    left = 3
                    right = 4
                    middle = 3

                    else condition -> nums[3] <= nums[4] -> 1 <= 2
                        right = 3

                Iteration 3:
                    * WON'T HAPPEN
                        * left = 3
                        * right = 3
                        * middle = 3
                        * CONDITION (left < right)  IS FALSE
                            * left == right
                                * 3 < 3 -> FALSE
                                    * 3 == 3
             */

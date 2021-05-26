class Solution {
    public int maxProduct(int[] nums) {
        /*
            We have to set result to some value
                * Can't be 0
                    * if nums = [-1] -> maxProduct would have to be -1 which is even less than 0
                    * So, 0 is not a good value to be assigned to result
         */
        int result = getMax(nums);

        /*
            if:
                currMax = 0
                currMin = 0

                * In the loop, you'd do:
                    * n * currMax OR n * currMin -> results in 0
                        * Incorrect

                * IDENTITY for multiplication is 1
         */
        int currMax = 1;
        int currMin = 1;

        for(int n : nums) {
            /*
             * Same explanation as the comment above:
             * All the multiplication we're going to do in the loop would result in a 0
             */
            if(n == 0) {
                currMax = 1;
                currMin = 1;
                continue;
            }

            // n * currMax would have a different value if it were to be used again in LINE 49
            int tmp = n * currMax;

            /*
                If nums had ALL POSITIVE NUMBERS -> maxProduct keeps INCREASING
                But if nums had ALL NEGATIVE NUMBERS -> maxProduct might decrease
                    * nums = [-1, -2, -3]
                        -1 * -2 = 2
                        2 * -3 = -6
                    * But you can also get 6 as the maxProduct
                        -2 * -3 = 6
                        * It makes sense to keep track of BOTH *maxProduct* AND *minProduct*
                            * Then, choose the max between those 2
             */
            currMax = Math.max(n * currMax, Math.max(n * currMin, n));
            currMin = Math.min(tmp, Math.min(n * currMin, n));

            result = Math.max(result, currMax);
        }

        return result;
    }

    private int getMax(int[] nums) {
        int max = nums[0];

        for(int n : nums) {
            if(n > max) {
                max = n;
            }
        }

        return max;
    }
}
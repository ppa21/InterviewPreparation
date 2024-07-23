class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array, making it easier for comparing elements in the array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        /*
         * consider [3, 4, 3, 1, 6, 8]
         *
         * nums.length - 2 because i will be the index from index 0 to index 3,
         * including those 2 indexes. So, nums.length - 2 = 4 -> i will be index 0, 1, 2, 3
         * since that's less than 4
         * i can't go to the very end because we have to find triplets, so i will go until
         * the third element from the back.
         */
        for(int i = 0; i < nums.length - 2; i++) {
            /*
             * check to make sure the solution set does not contain duplicate triplets
             */
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            /*
             * consider this array: [0, 9, 8, 7, 6, 5, 1, 2, 3, 4]
             * left will start at index 1 -> value 9.
             * right will start at index 9 -> value 4.
             */
            int left = i + 1;
            int right = nums.length - 1;

            /*
             * shrinking from both ends -> left increases and right decreases
             */
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    /* keep moving the left pointer to the right to ensure duplicate values
                     * or duplicate triplets are not selected
                     */
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    /* keep moving the right pointer to the left to ensure duplicate values
                     * or duplicate triplets are not selected
                     */
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if(sum > 0) {
                    /*
                     * this array is already sorted. if sum > 0, the only possible third
                     * element that could make the sum equal to 0 is going to be on
                     * the left side.
                     * So, shift the right pointer to the left by one -> right--;
                     */
                    right--;
                } else {
                    /*
                     * if sum < 0, the only possible third element that could make the sum
                     * equal to 0 is going to be on the right side.
                     * So, shift the left pointer to the right by one -> leff++;
                     */
                    left++;
                }
            }
        }

        return result;
    }
}

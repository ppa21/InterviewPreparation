class Solution {
    /*
            * Time Complexity: O(n)
            * Space Complexity: O(n)
     */

    /*
            * nums = [100, 4, 200, 1, 3, 2]
                * n = 100
                    * Does set have 99?
                        * NO
                            * START OF A SEQUENCE
                        * Does set have 101?
                            * NO
                                * CAN'T CONTINUE WITH THE SEQUENCE
                        * longestConsecutive = 1
                * n = 4
                    * Does set have 3?
                        * YES
                            * NOT THE START OF A SEQUENCE
                * n = 200
                    * Does set have 199?
                        * NO
                            * START OF A SEQUENCE
                        * Does set have 201?
                            * NO
                                * CAN'T CONTINUE WITH THE SEQUENCE
                        * longestConsecutive = 1
                * n = 1
                    * Does set have 0?
                        * NO
                            * START OF A SEQUENCE
                        * Does set have 2?
                            * YES
                                * CONTINUE WITH THE SEQUENCE
                        * Does set have 3?
                            * YES
                                * CONTINUE WITH THE SEQUENCE
                        * Does set have 4?
                            * YES
                                * CONTINUE WITH THE SEQUENCE
                        * Does set have 5?
                            * NO
                                * CAN'T CONTINUE WITH THE SEQUENCE
                        * longestConsecutive = 4
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 2) {
            return nums.length;
        }

        Set<Integer> set = new HashSet();

        for(int n : nums) {
            set.add(n);
        }

        int result = 0;

        for(int n : nums) {
            if(!set.contains(n - 1)) {
                int length = 1;

                while(set.contains(n + length)) {
                    length++;
                }

                result = Math.max(result, length);
            }
        }

        return result;
    }
}
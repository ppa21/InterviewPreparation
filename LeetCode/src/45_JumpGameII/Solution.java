class Solution {
    /*
        * Time Complexity  = O(n)
        * Space Complexity = O(1)
    */
    public int jump(int[] nums) {
        int result = 0;
        
        /*
            * nums = [2, 3, 1, 1, 4]

            * 3 windows -----> 2 jumps
                * 3 windows
                    * 2
                    * 3, 1
                    * 1, 4
                * 2 jumps
                    * 2    -> 3, 1
                    * 3, 1 -> 1, 4
        */
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            result++;
        }

        return result;
    }
}

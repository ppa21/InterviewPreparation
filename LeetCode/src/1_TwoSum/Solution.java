import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            /**
             * if the map contains the complement, you can return the index of the complement
             * from the map and the index i
             */
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            // otherwise, insert into map, value in nums at index i and the index i
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two values exist such that they give the result.");
    }
}
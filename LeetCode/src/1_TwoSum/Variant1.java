/*
		* time complexity  = O(n)
  		* space complexity = O(n)
*/
class Solution {
    public boolean twoSum_first_variant(int[] nums, int target) {
    	Set<Integer> complements = new HashSet<>();
		
    	for (int num : nums) {
        	int complement_num = target - num;
			
        	if (complements.contains(complement_num)) {
            	return true;
        	}
			
        	complements.add(num);
    	}
		
    	return false;
	}
}

/*
		* time complexity  = O(n)
  		* space complexity = O(n)

 		* Variant: What if you had to return T/F if you find at least one pair of numbers that add up to the target?
*/
class Solution {
    public boolean twoSum_first_variant(int[] nums, int target) {
    	Set<Integer> complements = new HashSet<>();
		
    	for (int n : nums) {
			int complement = target - num;
			
        	if (complements.contains(complement)) {
            	return true;
        	}
			
        	complements.add(n);
    	}
		
    	return false;
	}
}

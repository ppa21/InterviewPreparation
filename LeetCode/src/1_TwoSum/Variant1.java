/*
	* time complexity  = O(n)
  	* space complexity = O(n)
 
	* variant: what if you had to return T/F if you find at least one pair of numbers that add up to the target?
*/
class Solution {
    public boolean twoSumFirstVariant(int[] nums, int target) {
    	Set<Integer> complements = new HashSet<>();
		
    	for (int n : nums) {
	    int complement = target - n;
			
    	    if (complements.contains(complement)) {
                return true;
	    }
			
            complements.add(n);
    	}
		
    	return false;
    }
}

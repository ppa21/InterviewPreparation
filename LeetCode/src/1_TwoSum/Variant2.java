/*
        * time complexity  = O(n)
  	    * space complexity = O(n)
 
	    * variant: what if you had to return the number of domino pairs that add up to a target?
*/
class Solution {
    public int twoSumSecondVariant(int[][] dominoes, int target) {
        Map<Integer, Integer> dominoToFreq = new HashMap<>();
        int result = 0;
        
        for (int[] domino : dominoes) {
            int a1 = domino[0];
            int a2 = domino[1];
            int b1 = target - a1;
            int b2 = target - a2;
            int bKey = b1 * 10 + b2;
            
            if (dominoToFreq.containsKey(bKey)) {
                result += dominoToFreq.get(bKey);
            }
            
            int aKey = a1 * 10 + a2;
            dominoToFreq.put(aKey, dominoToFreq.getOrDefault(aKey, 0) + 1);
        }
        
        return result;
    }
}

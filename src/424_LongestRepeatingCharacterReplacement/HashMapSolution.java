class Solution {
    /*
            Time Complexity  = O(26n)
            Space Complexity = O(n)
     */
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap();
        int result = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);

            /*
                    * windowSize = right - left + 1
                        * right and left = indexes in s
                            * s is zero-based index
                                * so add 1 to right - left to get windowSize
                                    * windowSize = right - left + 1
             */
            if((right - left + 1) - Collections.max(count.values()) > k) {                  // WHILE instead of IF makes it faster?????
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
class Solution {
    /*
            Time Complexity  = O(n)
            Space Complexity = O(26) -> CONSTANT TIME
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int result = 0;
        int maxCount = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            int tmpCount = count[s.charAt(right) - 'A'];
            maxCount = Math.max(maxCount, tmpCount);

            // WHILE instead of IF since WHILE is faster than IF in this case
            while((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
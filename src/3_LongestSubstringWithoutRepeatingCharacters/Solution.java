class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int moving = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(moving < s.length()) {
            if(!set.contains(s.charAt(moving))) {
                set.add(s.charAt(moving));
                moving++;
                max = Math.max(set.size(), max);
            } else {
                /*
                 * set already contains that character -> we need to
                 * remove the character and in the next iteration,
                 * the removed character will be added again and
                 * moving will be incremented
                 */
                set.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }
}
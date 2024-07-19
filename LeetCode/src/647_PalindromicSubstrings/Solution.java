/*
        Solution SIMILAR to leetcode question 5. LONGEST PALINDROMIC SUBSTRING
 */
class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int count = 0;
        for(int begin = 0; begin < s.length(); begin++) {
            count += countPalindrome(s, begin, begin);
            count += countPalindrome(s, begin, begin + 1);
        }

        return count;
    }

    private int countPalindrome(String s, int begin, int end) {
        int count = 0;
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
            count++;
        }

        return count;
    }
}
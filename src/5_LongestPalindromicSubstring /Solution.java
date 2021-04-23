class Solution {
    private int start = 0;
    private int length = 0;

    public String longestPalindrome(String s) {
        /*
         * (s = "" || s = "a") -> palindrome -> return s;
         */
        if(s.length() < 2) {
            return s;
        }

        for(int begin = 0; begin < s.length() - 1; begin++) {
            /*
             * abcdcba -> string of odd length -> only one middle character -> d
             * -> move outwards in both directions from d
             */
            expand(s, begin, begin);

            /*
             * abccba -> string of even length -> 2 middle characters -> cc
             * -> move outwards in both directions from cc
             */
            expand(s, begin, begin + 1);
        }

        return s.substring(start, start + length);
    }

    private void expand(String s, int begin, int end) {
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        if(length < end - begin - 1) {
            start = begin + 1;
            length = end - begin - 1;
        }
    }
}
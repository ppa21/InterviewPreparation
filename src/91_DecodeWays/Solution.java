class Solution {
    public int numDecodings(String s) {
        // dp = represents number of ways to decode a string of length x
        int[] dp = new int[s.length() + 1];

        // dp[0] = number of ways to decode a string of length 0
        dp[0] = 1;          // base case

        // dp[1] = number of ways to decode a string of length 1
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {
            /*
             * ex. 21
             * oneDigit = 1
             * twoDigits = 21
             */
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));      // CURRENT character in a string -> converting to an int
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));     // CURRENT character and the PREVIOUS character in a string -> converting to an int

            // does oneDigit have a mapping already in dp?
            if(oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // does twoDigits have a mapping already in dp?
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
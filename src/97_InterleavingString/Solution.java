class Solution {
    /*
        * BOTTOM UP APPROACH

        * Time Complexity  = O(mn); m = size of s1; n = size of s2
        * Space Complexity = O(mn)
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // base case
        // An empty s3 can be formed by interleaving an empty s1 and an empty s2.
        dp[s1.length()][s2.length()] = true;

        // Start from the bottom right corner of the dp table and fill it up.
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // If we are not at the end of s1, check the following:
                if (i < s1.length()) {
                    // Check if the current character in s1 is the same as the character in s3 at the combined position of i and j.
                    // This is because s3 is an interleaved string of s1 and s2, so at any combined position of i and j in s3, the character should be either from s1 or s2.
                    if (s1.charAt(i) == s3.charAt(i + j)) {
                        // If the remaining characters after the current character in s1 can be interleaved, then we can say that the current set of characters can be interleaved.
                        if (dp[i + 1][j]) {
                            dp[i][j] = true;
                        }
                    }
                }
                // same logic as above
                if (j < s2.length()) {
                    if (s2.charAt(j) == s3.charAt(i + j)) {
                        if (dp[i][j + 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }
}

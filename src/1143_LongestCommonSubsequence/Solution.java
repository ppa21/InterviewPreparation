class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        /*
            If I start at i = 0 AND j = 0
                * lines 12, 13 and 15 -> WILL GO OUT OF BOUNDS
         */
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
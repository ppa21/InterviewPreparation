class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        /*
         m = 3, n = 2:

            1) How many rows do you have?
                -> dp.length = 3

            2) How many columns do you have?
                -> dp[0].length = 2
                -> In a loop, it'll be dp[i].length = 2
         */

        /*
         m = 3, n = 2:
                    j = 0     j = 1
            i = 0     1    |     x
            i = 1     1    |     x
            i = 2     1    |     x

         */
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        /*
         m = 3, n = 2:
                    j = 0     j = 1
            i = 0     1    |     1
            i = 1     1    |     x
            i = 2     1    |     x

         */
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        /*
         m = 3, n = 2:
                    j = 0     j = 1
            i = 0     1    |     1
            i = 1     1    |     dp[0][1] + dp[1][0] -> up (1) + left (1) = 2
            i = 2     1    |     dp[1][1] + dp[2][0] -> up (2) + left (1) = 3

         */
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        /*
            m = 3, n = 2 -> 3 rows and 2 columns
                rows index: 0, 1, 2 -> 3 total
                columns index: 0, 1 -> 2 total
                final answer will be in cell, row 2 and column 1
         */
        return dp[m - 1][n - 1];
    }
}
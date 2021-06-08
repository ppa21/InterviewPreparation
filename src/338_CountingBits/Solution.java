class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int msb = 1;

        for(int i = 1; i <= n; i++) {
            if(msb * 2 == i) {
                msb = i;
            }

            dp[i] = 1 + dp[i - msb];
        }

        return dp;
    }
}

/*
      Ex:
            n = 0   -   0000   -   no val   -   0 one   -   0
            n = 1   -   0001   -   msb: 1   -   1 one   -   1 + dp[n - msb] = 1 + dp[1 - 1] = 1 + 0 = 1
            n = 2   -   0010   -   msb: 2   -   1 one   -   1 + dp[n - msb] = 1 + dp[2 - 2] = 1 + 0 = 1
            n = 3   -   0011   -   msb: 2   -   2 one   -   1 + dp[n - msb] = 1 + dp[3 - 2] = 1 + 1 = 2
            n = 4   -   0100   -   msb: 4   -   1 one   -   1 + dp[n - msb] = 1 + dp[4 - 4] = 1 + 0 = 1
            n = 5   -   0101   -   msb: 4   -   2 one   -   1 + dp[n - msb] = 1 + dp[5 - 4] = 1 + 1 = 2
            n = 6   -   0110   -   msb: 4   -   2 one   -   1 + dp[n - msb] = 1 + dp[6 - 4] = 1 + 1 = 2
            n = 7   -   0111   -   msb: 4   -   3 one   -   1 + dp[n - msb] = 1 + dp[7 - 4] = 1 + 2 = 3
            n = 8   -   1000   -   msb: 8   -   1 one   -   1 + dp[n - msb] = 1 + dp[8 - 8] = 1 + 0 = 1
 */
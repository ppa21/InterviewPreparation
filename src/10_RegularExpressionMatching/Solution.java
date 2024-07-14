class Solution {
    /*
        * Dynamic Promgramming with Memoization

        * Time Complexity  = O(nm); n = size of s; m = size of p;
        * Space Complexity = O(nm)
    */ 
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        return dfs(dp, s, p, 0, 0);
    }

    private boolean dfs(boolean[][] dp, String s, String p, int i, int j) {
        // If the current state is already computed, return it
        if (dp[i][j]) {
            return dp[i][j];
        }

        // If both s and p are out of bounds, it's a match
        // For example, when s = "aab" and p = "c*a*b", this condition is met when i = 4 and j = 4
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // If we're out of bounds in p, but still in bounds in s, it's not a match
        // For example, when s = "aab" and p = "c*", this condition is met when i = 3 and j = 2
        if (j >= p.length()) {
            return false;
        }

        // Check if the current characters in s and p match or if the current character in p is '.'
        // '.' in p matches any single character in s
        // For example, when s = "aab" and p = ".*b", this condition is met when i = 1 and j = 1
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If the next character in p is '*', then either skip it or match it with a character in s
        // '*' in p means the preceding character can appear zero or more times in s
        // For example, when s = "aab" and p = "c*a*b", this condition is met when i = 0 and j = 0
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // (i, j + 2) is used to skip the current character and '*' in p
            // (i + 1, j) is used when the current character in s matches the current character in p, allowing us to check for further repetitions of the character in s while staying at the current position in p
            // For example, when s = "aab" and p = "c*a*b", this condition is met when i = 0 and j = 0
            dp[i][j] = dfs(dp, s, p, i, j + 2) || (match && dfs(dp, s, p, i + 1, j));
        } else {
            // If the current characters in s and p match, move to the next characters in both s and p
            // For example, when s = "aab" and p = "aab", this condition is met when i = 0 and j = 0
            dp[i][j] = match && dfs(dp, s, p, i + 1, j + 1);
        }

        // Return the computed state
        return dp[i][j];
    }
}

class Solution {
    /*
        * BOTTOM UP APPROACH

        * Time Complexity  = O(mn); m = size of word1; n = size of word2
        * Space Complexity = O(mn);
    */
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                // If the first string is empty, we need to perform 'j' insertions to match the second string
                if (i == 0) {
                    dp[i][j] = j;
                }

                // If the second string is empty, we need to perform 'i' deletions to match the first string
                else if (j == 0) {
                    dp[i][j] = i;
                }

                // If the current characters of both strings are the same, the minimum edit distance doesn't change
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // If the current characters are different, we consider all possibilities (insert, remove, replace) and choose the minimum
                else {
                    // Insert: Consider the scenario where a character from word2 is inserted into word1. So, we move to the previous character in word2, but stay at the current character in word1
                    // Remove: Consider the scenario where a character from word1 is removed. So, we move to the previous character in word1, but stay at the current character in word2
                    // Replace: Consider the scenario where a character in word1 is replaced with the current character in word2. So, we move to the previous character in both strings
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

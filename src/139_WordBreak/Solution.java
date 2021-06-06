class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        int maxWordLength = 0;
        for(String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        dp[0] = true;   // Base case because by default, every element in dp is false.
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                /*
                 * i - j is the length of an invalid word
                 * Ex:
                 * maxWordLength = 4 ---> "Leet" or "Code" = length = 4
                 * i - j = 6 ---> "etCode" ---> Invalid word
                 * Therefore, don't bother with the rest of the loop
                 * Continue
                 */
                if(i - j > maxWordLength) {
                    continue;
                }

                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
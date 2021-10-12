/*
        Time Complexity: O(n^3)
        Space Complexity: O(n)
 */
class Solution {

    private Set<String> discovered = new HashSet();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList();

        if(words.length == 0) {
            return result;
        }

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(String word : words) {
            if(isComposite(word)) {
                result.add(word);
            }

            discovered.add(word);
        }

        return result;
    }

    private boolean isComposite(String word) {
        if(discovered.size() == 0) {
            return false;
        }

        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && discovered.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }
}
/*
         * Time Complexity:  O(n) where n is the length of the input string
         * Space Complexity: O(n) for the stack to store character objects and result string

         * VARIANT: What if you had to remove all adjacent duplicates as you iterate
           left-to-right?
 */
class Solution {
    public String removeDuplicates(String s) {
        List<CharFreq> letters = new ArrayList<>();
        
        for (char c : s.toCharArray()) {
            // Start first group
            if (letters.isEmpty()) {
                letters.add(new CharFreq(c, 1));
                continue;
            }
            
            // Same char as last group - increment count
            if (letters.get(letters.size() - 1).c == c) {
                letters.get(letters.size() - 1).freq++;
                continue;
            }
            
            // New char encountered - remove the completed group if it had duplicates (freq > 1)
            if (letters.get(letters.size() - 1).freq > 1) {
                letters.remove(letters.size() - 1);
            }
            
            if (letters.isEmpty() || letters.get(letters.size() - 1).c != c) {
                letters.add(new CharFreq(c, 1));
            } else if (letters.get(letters.size() - 1).c == c) {
                letters.get(letters.size() - 1).freq++;
            }
        }
        
        // Remove final group if it has duplicates
        if (!letters.isEmpty() && letters.get(letters.size() - 1).freq > 1) {
            letters.remove(letters.size() - 1);
        }
        
        StringBuilder result = new StringBuilder();
        for (CharFreq letter : letters) {
            result.append(letter.c);
        }
        
        return result.toString();
    }

	class CharFreq {
        char c;
        int freq;
        
        CharFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}

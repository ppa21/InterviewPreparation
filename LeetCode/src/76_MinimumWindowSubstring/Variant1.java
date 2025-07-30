/*
        * Problem: Given word array 'sentence' and target words 'words', find minimum contiguous 
          subarray that contains all target words (at least once each).
        
        * Example: sentence = ['is','one','ok','you','the','frog','ok','one','the','you','is','not','frog']
                      words = ['is','you','frog'] 
                            → return "you is not frog"
        
        * Time Complexity:      O(2N + M) ---> O(N + M) ---> N = sentence.length, M = words.length
        * Space Complexity:     O(M) for HashMap + O(result) for output ---> Typically O(M)
*/
class Solution {
    public String minWindow(String[] sentence, String[] words) {
        if(sentence == null || sentence.length == 0 || words == null || words.length == 0) {
            return "";
        }
      
        Map<String, Integer> map = new HashMap();    // think of map as a SHOPPING LIST <word, count of word needed>
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
      
        int i = 0;
        int j = 0;
        int count = map.size();             // count = map.size() ---> count of UNIQUE words ONLY
        int left = 0;
        int right = sentence.length - 1;    // LAST INDEX of array sentence
        int min = sentence.length;
        boolean found = false;
      
        while(j < sentence.length) {
            String endWord = sentence[j];
            j++;
            
            if(map.containsKey(endWord)) {                    // if the shopping list contains this word we need
                map.put(endWord, map.get(endWord) - 1);       // we get that word, DECREMENT it's count (value of shopping list)
                if(map.get(endWord) == 0) {                   // if we get all quantities needed for that word
                    count--;                                  // we don't need that WORD anymore (count/number of words we need is DECREASED)
                }
            }
          
            // if we still have words that we need from the SHOPPING LIST
            // count is GREATER THAN 0 ---> continue moving the j pointer FORWARD
            if(count > 0) {
                continue;
            }
          
            /*
                    * subarray FOUND
                    * REMOVE USELESS words from the subarray while STILL HAVING all words from target
            */
            // SOLUTION FOUND
            // see if we can find a SMALLER WINDOW
            while(count == 0) {
                // UPDATE POINTERS - check if current window is smaller BEFORE moving i
                if((j - i) < min) {
                    left = i;
                    right = j;
                    min = j - i;
                    found = true;
                }
                
                String startWord = sentence[i];
                i++;
                if(map.containsKey(startWord)) {                    
                    map.put(startWord, map.get(startWord) + 1);
                    if(map.get(startWord) > 0) {
                        count++;
                    }
                }
            }
        }
        
        if(!found) {
          return "";
        }
        
        // Join the words with spaces instead of substring
        StringBuilder result = new StringBuilder();
        for(int k = left; k < right; k++) {
            if(k > left) {
              result.append(" ");
            }
            result.append(sentence[k]);
        }
      
        return result.toString();
    }
}

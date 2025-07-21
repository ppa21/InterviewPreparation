/*
        * time complexity  = O(A); loop ends when we run out of characters in abbr string
        * space complexity = O(1)
*/
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int a = 0;
        int w = 0;
        
        while (a < abbr.length() && w < word.length()) {
            if (abbr.charAt(a) == word.charAt(w)) {
                a++;
                w++;
                continue;
            }
            
            if (!Character.isDigit(abbr.charAt(a)) && abbr.charAt(a) != word.charAt(w)) {
                return false;
            }
            
            if (abbr.charAt(a) == '0') {
                return false;
            }
            
            int skip = 0;
            while (a < abbr.length() && Character.isDigit(abbr.charAt(a))) {
                skip = skip * 10 + (abbr.charAt(a) - '0');
                a++;
            }
            
            w += skip;
        }
        
        return a == abbr.length() && w == word.length();
    }
}

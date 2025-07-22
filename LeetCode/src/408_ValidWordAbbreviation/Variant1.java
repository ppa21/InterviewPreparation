/*
        * time complexity  = O(2^(A + W)); 2 choices to match either 0, 1 or more
        * space complexity = O(W)

        * Variant: wildcard (*) is introduced BUT no leading zeros
*/
public class Solution {
    private boolean recurse(String word, String abbr, int w, int a) {
        if (w == word.length() && a == abbr.length()) {
            return true;
        }
      
        if (w < word.length() && a == abbr.length()) {
            return false;
        }
      
        if (w == word.length() && a < abbr.length()) {
            for (int i = a; i < abbr.length(); i++) {
                if (abbr.charAt(i) != '*') {
                    return false;
                }
            }
          
            return true;
        }
      
        if (Character.isDigit(abbr.charAt(a))) {
            int skip = 0;
            while (a < abbr.length() && Character.isDigit(abbr.charAt(a))) {
                skip = skip * 10 + (abbr.charAt(a) - '0');
                a++;
            }
            w += skip;
               
            if (w > word.length()) {
                return false;
            }
               
            return recurse(word, abbr, w, a);
        }
           
        if (abbr.charAt(a) == '*') {
            return recurse(word, abbr, w, a + 1) ||
                   recurse(word, abbr, w + 1, a);
        }
      
        if (word.charAt(w) == abbr.charAt(a)) {
            return recurse(word, abbr, w + 1, a + 1);
        }
      
        return false;
    }
    
    public boolean validWordAbbreviation(String word, String abbr) {
        return recurse(word, abbr, 0, 0);
    }
}

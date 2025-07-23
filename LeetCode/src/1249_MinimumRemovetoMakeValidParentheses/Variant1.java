/*
     * time complexity  = O(n)
     * space complexity = O(n) - but slightly more space efficient than StringBuilder

     * VARIANT: Space-optimized approach using char array. IN PLACE like c++ can't be done can't be done 
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int extraOpens = 0;
        int totalOpens = 0;
        char[] chars = s.toCharArray();    // modify this char[] in place and keep track of index j. and then just substring it based on index j
        int j = 0;
    
        for (char ch : chars) {
            if (ch == ')') {
                if (extraOpens == 0) {
                    continue;
                }
                
                extraOpens--;
                chars[j] = ch;
                j++;
            } else if (ch == '(') {
                totalOpens++;
                extraOpens++;
                chars[j] = ch;
                j++;
            } else {
                chars[j] = ch;
                j++;
            }
        }
    
        int length = j;
        j = 0;
        int keep = totalOpens - extraOpens;
    
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                if (keep == 0) {
                    continue;
                }
                chars[j] = ch;
                j++;
                keep--;
            } else {
                chars[j] = ch;
                j++;
            }
        }
    
        return new String(chars, 0, j);
    }
}

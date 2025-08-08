/*
        * time complexity  = O(n)
        * space complexity = O(n)

        * VARIANT: What if you had to return the parentheses string itself after the minimum adds?
 */
class Solution {
    public String minAddToMakeValid(String s) {
        int extraOpens = 0;     
        StringBuilder result = new StringBuilder();
    
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (extraOpens == 0) {
                    result.append('(');
                    result.append(')');
                    continue;
                }
                
                extraOpens--;
                result.append(ch);
            } else if (ch == '(') {
                extraOpens++;
                result.append(ch);
            } else {
                result.append(ch);
            }
        }
    
        // Add closing parentheses for any remaining unmatched opens
        for (int i = 0; i < extraOpens; i++) {
            result.append(')');
        }
    
        return result.toString();
    }
}

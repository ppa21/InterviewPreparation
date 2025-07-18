import java.util.*;

/*
       * time complexity  = O(n)
       * space complexity = O(n)

       * VARIANT: What if you were given different types of parentheses?
 */
class Solution {
    public String deleteLeastParentheses(String s) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
        
        Map<Character, Integer> extraOpens = new HashMap<>();
        Map<Character, Integer> totalOpens = new HashMap<>();
        
        StringBuilder temp = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (mapping.containsKey(ch)) { // Closing parentheses
                char openChar = mapping.get(ch);
                if (extraOpens.getOrDefault(openChar, 0) == 0) {
                    continue;
                }
              
                extraOpens.put(openChar, extraOpens.get(openChar) - 1);
                temp.append(ch);
            } else if (Character.isLetterOrDigit(ch)) { // Alphanumeric characters
                temp.append(ch);
            } else { // Opening parentheses
                extraOpens.put(ch, extraOpens.getOrDefault(ch, 0) + 1);
                totalOpens.put(ch, totalOpens.getOrDefault(ch, 0) + 1);
                temp.append(ch);
            }
        }
        
        Map<Character, Integer> keep = new HashMap<>();
        for (char open : totalOpens.keySet()) {
            keep.put(open, totalOpens.get(open) - extraOpens.get(open));
        }
        
        StringBuilder result = new StringBuilder();
        
        for (char ch : temp.toString().toCharArray()) {
            if (totalOpens.containsKey(ch)) { // Opening parentheses
                if (keep.get(ch) == 0) {
                    continue;
                }
              
                keep.put(ch, keep.get(ch) - 1);
                result.append(ch);
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}

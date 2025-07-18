/*
        * time complexity  = O(n)
        * space complexity = O(n)
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int extraOpens = 0;     
        int totalOpens = 0;
        StringBuilder temp = new StringBuilder();
    
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (extraOpens == 0) {
                    continue;
                }
                
                extraOpens--;
                temp.append(ch);
            } else if (ch == '(') {
                totalOpens++;
                extraOpens++;
                temp.append(ch);
            } else {
                temp.append(ch);
            }
        }
    
        StringBuilder result = new StringBuilder();
        int keep = totalOpens - extraOpens;
    
        for (char ch : temp.toString().toCharArray()) {
            if (ch == '(') {
                if (keep == 0) {
                    continue;
                }
                result.append(ch);
                keep--;
            } else {
                result.append(ch);
            }
        }
    
        return result.toString();
    }
}

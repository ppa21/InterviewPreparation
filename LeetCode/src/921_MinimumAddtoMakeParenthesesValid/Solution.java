/*
        * time complexity  = O(n)
        * space complexity = O(1)
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int extraOpens = 0;     
        int minAdds = 0;
    
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (extraOpens == 0) {
                    minAdds++;
                    continue;
                }
                
                extraOpens--;
            } else if (ch == '(') {
                extraOpens++;
            }
        }
    
        return minAdds + extraOpens;
    }
}

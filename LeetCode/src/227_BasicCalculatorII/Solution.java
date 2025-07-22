/*
        * time complexity  = O(n)
        * space complexity = O(1)
*/
class Solution {
    public int calculate(String s) {
        // build currNum digit by digit like "123"
        int currNum = 0;    
        // hold the prevNum until we know what to do with it; because what if the next operator is * or / and we lost the prevNum to + or -
        int prevNum = 0;    
        int result = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // "123" becomes 1, then 12, then 123
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');  
            }
            
            //  When we hit an operator OR reach the end
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    result += prevNum;    
                    prevNum = currNum;    
                } else if (op == '-') {
                    result += prevNum;     
                    prevNum = -currNum;           // because - 
                } else if (op == '*') {
                    prevNum = prevNum * currNum;  // Multiply immediately (high priority!)
                } else if (op == '/') {
                    prevNum = prevNum / currNum;  // Divide immediately (high priority!)
                }
                
                // Reset
                currNum = 0;    
                op = c;        
            }
        }

        result += prevNum;
        
        return result;
    }
}

public class Solution {
    /*
        * Time Complexity  = O(n); n = size of s;
        * Space Complexity = O(1)
    */
    public boolean checkValidString(String s) {
        int min = 0; // minimum number of OPEN PARENTHESES (treat '*' as ')' or nothing)
        int max = 0; // maximum number of OPEN PARENTHESES (treat '*' as '(')

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If it's an opening parenthesis, increment both min and max
                min++;
                max++;
            } else if (c == ')') {
                // If it's a closing parenthesis, decrement both min and max
                // min can't be negative, so take max with 0
                min = Math.max(min - 1, 0);
                max--;
            } else {
                // If it's '*', it could be ( or ) or nothing
                // min is decremented (consider '*' as ')')
                // max is incremented (consider '*' as '(')
                min = Math.max(min - 1, 0);
                max++;
            }

            // If max is negative, there are more closing parentheses than opening ones
            // So the string is not valid
            if (max < 0) {
                return false;
            }
        }

        /* 
            * If min is more than 0, there are more opening parentheses than closing ones
              So the string is not valid

            * If min is 0, the number of opening and closing parentheses is balanced
              So the string is valid
        */
        return min == 0;
    }
}

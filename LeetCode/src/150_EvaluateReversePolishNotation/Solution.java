class Solution {
    /*
            Time Complexity: O(n)
            Space Complexity: O(n)
     */
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if(token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if(token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if(token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
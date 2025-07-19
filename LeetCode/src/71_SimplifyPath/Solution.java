/*
        * time complexity  = O(n)
        * space complexity = O(n)
*/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> tokens = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }

            if (part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (tokens.isEmpty()) {
                    continue;
                }
                tokens.pop();
            } else {
                tokens.push(part);
            }
        }

        if (tokens.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String s : tokens) {
            result.append("/").append(s);
        }

        return result.toString();
    }
}

/*
        * time complexity  = O(n)
        * space complexity = O(n)

        * VARIANT: What if you were given a new "cd" parameter to change where you currently
          were on your filesystem (represented by "cwd")? If "cd" starts with "/" then this has
          many implications on the code.
*/
class Solution {
    public String changeDirectory(String cwd, String cd) {
        if (cd.isEmpty()) {
            return cwd;
        }

        // go back to the root
        if (cd.charAt(0) == '/') {
            cwd = "";
        }

        Stack<String> tokens = new Stack<>();

        String[] cwdParts = cwd.split("/");
        for (String part : cwdParts) {
            if (part.isEmpty()) {
                continue;
            }

            tokens.push(part);
        }

        String[] cdParts = cd.split("/");
        for (String part : cdParts) {
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

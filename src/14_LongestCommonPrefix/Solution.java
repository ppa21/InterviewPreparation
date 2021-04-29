class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            /*
             * String str = "Welcome to geeksforgeeks";
             * String prefix = "geeks";
             *
             * str.indexOf(prefix) ----> 11
             *
             * So, using the while loop condition, we want to make sure that
             * the prefix happens at the start of the string AKA start, at index 0.
             * If it does, that means strs[i] has prefix that starts at index 0 and
             * we move on to the next iteration of the for loop.
             *
             * If it doesn't, that means strs[i] doesn't contain the prefix, so we want
             * to shorten the prefix by one character and see if strs[i] contains the shortened
             * prefix. We continue this until we find a prefix such that strs[i] contains that
             * prefix. If there is no such prefix, we return an empty string.
             *
             * Consider this array: strs = ["flower","flow","flight"]
             * prefix = "flower"
             * for
             *  i = 1 -> while
             *              "flow".indexOf("flower") != 0
             *                  -> "flowe" -> "flow"
             * i = 2 -> while
             *              "flight".indexOf("flow") != 0
             *                  -> "flo" -> "fl"
             * return prefix which is "fl"
             */
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // if there is no common prefix between all strings in the array -> return an empty string
                if(prefix.length() == 0) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
/*
        * Time Complexity:  O(n)
        * Space Complexity: O(n)
 */
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // result.isEmpty()
            if (result.length() == 0 || result.charAt(result.length() - 1) != ch) {
                result.append(ch);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }
}

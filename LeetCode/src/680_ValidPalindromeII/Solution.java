/*
        * time complexity  = O(n)
        * space complexity = O(1)
*/
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                return checkRemaining(s, left + 1, right) || checkRemaining(s, left, right - 1);
            }
        }

        return true;
    }

    private boolean checkRemaining(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}

/*
    * Time Complexity  = O(n2^n); n = size of s
    * Space Complexity = O(n2^n)
*/
class Solution {
    // finds all possible ways to split a string s into smaller palindrome substrings
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s.equals("")) {
            result.add(new ArrayList<>());
            return result;
        }

        /* 
            * we iterate through the word s, considering each letter as a potential end of a palindrome 
                * i.e. adding more letters won't make it a palindrome
        */
        for (int i = 0; i < s.length(); i++) {
            // check if substring from START to CURRENT letter is a palindrom
            if (isPalindrome(s, i + 1)) {
                // if it is, we find palindromic partitions for the remaining part of the string 
                for (List<String> list : partition(s.substring(i + 1, s.length()))) {
                    // we add current palindrome substring to the BEGINNING of each partition found
                    list.add(0, s.substring(0, i + 1));
                    result.add(list);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

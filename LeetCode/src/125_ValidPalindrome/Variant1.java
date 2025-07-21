/*
        * time complexity = O(n + k); n = size of s, k = size of include
        * space complexity = O(k)

        * Variant: What if you could only consider a limited set of characters as a part of
          a potential palindrome?
*/
class Solution {
    public boolean isPalindrome(String s, List<Character> include) {
        Set<Character> includedSet = new HashSet<>(include);
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            while(left < right && !includedSet.contains(s.charAt(left))) {
                left++;
            }
            
            while(left < right && !includedSet.contains(s.charAt(right))) {
                right--;
            }
            
            if(left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}

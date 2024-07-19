class Solution {
    public boolean isPalindrome(int x) {
        int palindrome = x;
        int remainder = 0;
        int reverse = 0;

        while(palindrome != 0) {
            remainder = palindrome % 10;
            palindrome /= 10;
            reverse = reverse * 10 + remainder;
        }

        if(x < 0) {
            reverse *= -1;
        }

        return x == reverse;
    }
}
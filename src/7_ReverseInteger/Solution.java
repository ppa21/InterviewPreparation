class Solution {
    public int reverse(int x) {
        int remainder = 0;
        int result = 0;

        while(x != 0) {
            remainder = x % 10;
            result = result * 10 + remainder;
            x /= 10;
        }

        if(remainder > Integer.MAX_VALUE || remainder < Integer.MIN_VALUE) {
            return 0;
        }

        return result;
    }
}
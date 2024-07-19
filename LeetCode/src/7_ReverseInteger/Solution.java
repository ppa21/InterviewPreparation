class Solution {
    public int reverse(int x) {
        int remainder = 0;
        int result = 0;

        while(x != 0) {
            remainder = x % 10;
            x /= 10;

            if(result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE && result > 7) {
                return 0;
            }

            if(result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE && result < -8) {
                return 0;
            }

            result = result * 10 + remainder;
        }

        return result;
    }
}
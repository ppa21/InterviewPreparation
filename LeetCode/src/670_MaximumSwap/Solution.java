/*
        * time complexity  = O(n)
        * space complexity = O(1)
*/
class Solution {
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        char[] digits = numStr.toCharArray();
        
        // Track last position of each digit 0-9
        int[] rightmostIndex = new int[10];
        Arrays.fill(rightmostIndex, -1);
        
        for (int i = 0; i < digits.length; i++) {
            rightmostIndex[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            // Try to replace current digit with a larger one
            for (int digit = 9; digit > digits[i] - '0'; digit--) {
                // Only swap with digits that come after current position
                if (rightmostIndex[digit] > i) {
                    char temp = digits[i];
                    digits[i] = digits[rightmostIndex[digit]];
                    digits[rightmostIndex[digit]] = temp;
                    
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        return num;
    }
}

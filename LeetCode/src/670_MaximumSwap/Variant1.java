/*
         * time complexity  = O(n)
         * space complexity = O(1)

         * Variant: What if you had to build the second largest number?
 */
class Solution {
    public List<Integer> getSecondLargestNumber(List<Integer> num) {
        if (num.isEmpty() || num.size() == 1) {
            return new ArrayList<>();
        }
        
        // Count how many times each digit appears
        int[] freqs = new int[10];
        for (int digit : num) {
            freqs[digit]++;
        }
        
        // Create the maximum possible number from our digits
        List<Integer> largestNum = new ArrayList<>();
        for (int digit = 9; digit >= 0; digit--) {
            for (int times = 0; times < freqs[digit]; times++) {          // If we have any of this digit, add them all now
                largestNum.add(digit);
            }
        }
        
        // Find rightmost position where we can make a smaller swap
        // we want to swap on the rightmost side because the value of those numbers is smaller
        for (int i = largestNum.size() - 1; i > 0; i--) {
            if (!largestNum.get(i).equals(largestNum.get(i - 1))) {
                Collections.swap(largestNum, i, i - 1);              // Swap to create second largest number
                return largestNum;
            }
        }
        
        return new ArrayList<>();
    }
}

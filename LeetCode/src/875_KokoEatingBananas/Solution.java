class Solution {
    /*
        * time complexity  = O(log(MAX(values in piles[])) * size of piles array)
        * space complexity = O(1)
     */

    /*
            Imagine Koko the monkey has piles of bananas and needs to eat them all within h hours. 
            She can choose how fast to eat (bananas per hour), but once she picks a speed, she sticks with it. 
            We want to find the slowest speed that still lets her finish in time.
    */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;                         // slowest speed
        int right = 1;                        // fastest speed
        for (int pile : piles) {
            right = Math.max(right, pile);    // fastest speed possible
        }
        int result = right;

        while (left <= right) {
            int middle = left + (right - left) / 2; // try the middle speed
            int hourSpent = 0;                      // hoursSpent with middle speed

            // if i eat at middle speed, how long does it take for me to finish all bananas
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // if we finish in time, middle speed works, but maybe we can go slower so search left of middle
            if (hourSpent <= h) {
                result = Math.min(result, middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }
}

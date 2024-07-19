class Solution {
    /*
        * time complexity  = O(log(MAX(values in piles[])) * size of piles array)
        * space complexity = O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 0;
        int right = 1; // max speed will be max number in piles i.e. how many bananas can be eaten at max in an hr
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int result = right;

        while (left <= right) {
            /*
                * Get the middle index between left and right boundary indexes.
                * hourSpent stands for the total hour Koko spends.
             */
            int middle = left + (right - left) / 2; // middle = k
            int hourSpent = 0;

            /*
                * Iterate over the piles and calculate hourSpent.
                * We increase the hourSpent by ceil(pile / middle)
             */
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            /*
                * if hourSpent is less than given h, we see if we can find less hourSpent AKA better speed to eat bananas/hr
             */
            if (hourSpent <= h) {
                result = Math.min(result, middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        /*
            * Once the left and right boundaries coincide, we find the target value,
            * that is, the minimum workable eating speed.
         */
        return result;
    }
}

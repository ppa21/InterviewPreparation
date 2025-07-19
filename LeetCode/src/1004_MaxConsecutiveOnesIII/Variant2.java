/*
        * time complexity  = O(n)
        * space complexity = O(1)

        * VARIANT: What if Meta presents the OG problem in the context of PTO days you want to take off?
          Specifically, you're given a array of booleans where T means it's a weekend, and F means
          it's a week day.
*/
class Solution {
    public int longestOnes(boolean[] year, int pto) {
        int maxVacation = 0;
        int left = 0;
        int right = 0;

        while (right < year.length) {
            if (!year[right]) {
                pto--;
            }

            while (pto < 0) {
                if (!year[left]) {
                    pto++;
                }

                left++;
            }

            maxVacation = Math.max(maxVacation, right - left + 1);
            right++;
        }

        return maxVacation;
    }
}

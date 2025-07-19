/*
        * time complexity  = O(n)
        * space complexity = O(1)

        * VARIANT: What if Meta presents the OG problem in the context of PTO days you want to take off?
          Specifically, you're given a char array of 'W' for work days and 'H' for weekends.
*/
class Solution {
    public int longestOnes(char[] days, int pto) {
        int maxVacation = 0;
        int left = 0;
        int right = 0;

        while (right < days.length) {
            if (days[right] == 'W') {
                pto--;
            }

            while (pto < 0) {
                if (days[left] == 'W') {
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

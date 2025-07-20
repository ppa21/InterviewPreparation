/*
        * time complexity  = O(nm)
        * space complexity = O(1)

        * Variant: now has matrix instead of arr (1D --> 2D)
*/
class Solution {    
    public int getMaxVacations(char[][] days, int pto) {
        int maxVacation = 0;
        int currVacation = 0; // opposite operation of pto
        int[] left = {0, 0}; // [row, col]
        
        for (int row = 0; row < days.length; row++) {
            for (int col = 0; col < days[0].length; col++) {
                if (days[row][col] == 'W') {
                    pto--;
                }
                currVacation++;
                
                while (pto < 0) {
                    if (days[left[0]][left[1]] == 'W') {
                        pto++;
                    }
                    left = shrinkWindow(days, left);
                    currVacation--;
                }
                
                maxVacation = Math.max(currVacation, maxVacation);
            }
        }
        
        return maxVacation;
    }

      public int[] shrinkWindow(char[][] days, int[] left) {
        int row = left[0];
        int col = left[1];
          
        if (col == days[0].length - 1) {
            return new int[]{row + 1, 0};
        }
          
        return new int[]{row, col + 1};
    }
}

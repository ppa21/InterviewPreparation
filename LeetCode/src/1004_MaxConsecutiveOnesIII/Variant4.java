/*
        * time complexity  = O(n)
        * space complexity = O(1)

        * VARIANT: pto can be given as a decimal; whole pto and partial pto
*/
class Solution {    
    public double getMaxVacations(char[] days, double pto) {
        double maxVacation = 0.0;
        double wholePto = Math.floor(pto); // 3.7 -> 3
        double partialPto = pto - wholePto; // 3.7 - 3 = 0.7 
        int left = 0;

        // while loop can be used: while (right < days.length)
        for (int right = 0; right < days.length; right++) {
            if (days[right] == 'W') {
                wholePto--;
            }
            
            while (wholePto < 0) {
                if (days[left] == 'W') {
                    wholePto++;
                }
              
                left++;
            }
            
            double extension = 0.0;
            if ((left > 0 && days[left - 1] == 'W') ||
                (right < days.length - 1 && days[right + 1] == 'W')) {
                extension = partialPto;
            }
            
            maxVacation = Math.max(maxVacation, right - left + 1 + extension);
        }
      
        return maxVacation;
    }
}

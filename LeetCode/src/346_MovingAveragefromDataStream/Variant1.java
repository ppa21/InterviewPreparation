/*
        * time complexity  = O(n)
        * space complexity = O(n)

        * Variant: What if you had to return a resulting array of the averages of each subarray of size, "size"?
*/
public class SlidingWindowAverage {
    public static List<Double> computeRunningAverage(int[] nums, int windowSize) {
        List<Double> result = new ArrayList<>();
        int windowSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            
            int left = right - windowSize;                     // left is past the windowSize now
            if (left >= 0) {
                windowSum -= nums[left];
            }
            
            if (right >= windowSize - 1) {                     // do we have windowSize elements to compute the average?
                result.add((double) windowSum / windowSize);
            }
        }
        
        return result;
    }
}

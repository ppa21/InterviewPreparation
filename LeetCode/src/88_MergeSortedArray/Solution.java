/*
        * time complexity  = O(m + n)
        * space complexity = O(1)
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 has length m + n: first m elements are data, last n are 0s (ignored/overwritten)
        // we merge into nums1 itself, working backwards to avoid overwriting unprocessed data
        
        int a = m - 1;      // Last actual element in nums1, before 0s
        int b = n - 1;      // Last element in nums2  
        int i = m + n - 1;  // Last position in nums1 (start filling from here)
        
        while (b >= 0) {
            if (a >= 0 && nums1[a] >= nums2[b]) {
                nums1[i] = nums1[a];
                a--;
            } else {
                nums1[i] = nums2[b];
                b--;
            }
            i--;
        }
    }
}

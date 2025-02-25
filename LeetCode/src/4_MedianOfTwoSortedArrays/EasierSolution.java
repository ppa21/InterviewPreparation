/*
  Time Complexity: O(n + m); n = nums1.length, m = nums2.length
  Space Complexity: O(n + m)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedArray = new int[totalLength];
        
        int i = 0; // index for nums1
        int j = 0; // index for nums2
        int k = 0; // index for mergedArray
        
        // Merge the two sorted arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
                k++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        // Add remaining elements from nums1, if any
        while (i < nums1.length) {
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        
        // Add remaining elements from nums2, if any
        while (j < nums2.length) {
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        
        // Find the median of the merged array
        if (totalLength % 2 != 0) {
            // Odd length: return the middle element
            return mergedArray[totalLength / 2];
        } else {
            // Even length: return the average of the two middle elements
            int mid1 = mergedArray[totalLength / 2 - 1];
            int mid2 = mergedArray[totalLength / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}

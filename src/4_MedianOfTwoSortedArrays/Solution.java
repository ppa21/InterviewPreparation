public class Solution {
    /*
        * Time Complexity  = O(log(min(m, n)))
        * Space Complexity = O(1)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array. If not, swap nums1 and nums2.
        // This is done to ensure that the binary search is performed on the smaller array, which improves efficiency.
        // For example, if nums1 = [1, 3] and nums2 = [2], then nums1 and nums2 are swapped.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int nums1Length = nums1.length; // nums1Length = 1
        int nums2Length = nums2.length; // nums2Length = 2

        // Binary search on the smaller array.
        int start = 0;
        int end = nums1Length;

        while (start <= end) {
            // The point where we partition nums1. Initially, partitionNums1 = 0
            int partitionNums1 = (start + end) / 2; 
            /* 
                The point where we partition nums2. Initially, partitionNums2 = 2
                We subtract partitionNums1 to ensure that the total number of elements on the left side of the partition
                (in both nums1 and nums2) is the same as the total number of elements on the right side if even
                (or one more, if the total number of elements is odd).
            */
            int partitionNums2 = (nums1Length + nums2Length + 1) / 2 - partitionNums1; 

            // If partitionNums1 is 0 it means nothing is there on left side. Use INT_MIN for maxLeftNums1. Same for maxLeftNums2.
            int maxLeftNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1]; // maxLeftNums1 = Integer.MIN_VALUE
            int minRightNums1 = (partitionNums1 == nums1Length) ? Integer.MAX_VALUE : nums1[partitionNums1]; // minRightNums1 = 2

            int maxLeftNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1]; // maxLeftNums2 = 1
            int minRightNums2 = (partitionNums2 == nums2Length) ? Integer.MAX_VALUE : nums2[partitionNums2]; // minRightNums2 = 3

            /* 
                We have partitioned nums1 and nums2 at the correct place
                Now get max of left elements and min of right elements to get the median in case of even length combined array size
                or get max of left for odd length combined array size.
            */
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((nums1Length + nums2Length) % 2 == 0) {
                    return ((double) Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2; // EVEN CASE
                } else {
                    return (double) Math.max(maxLeftNums1, maxLeftNums2); // Returns 1 as the median; ODD CASE
                }
            } else if (maxLeftNums1 > minRightNums2) { // We are too far on right side for partitionNums1. Go on left side.
                end = partitionNums1 - 1;
            } else { // We are too far on left side for partitionNums1. Go on right side.
                start = partitionNums1 + 1;
            }
        }

        // Input arrays are not sorted.
        throw new IllegalArgumentException();
    }
}

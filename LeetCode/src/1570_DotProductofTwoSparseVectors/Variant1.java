/*
         * time complexity  = O(min(L1, L2) * log(max(L1, L2))); where L1, L2 are non-zero values in each list
         * space complexity = O(L1) + O(L2)

         * VARIANT: What if you had to optimize your algorithm using binary search?
 */
class SparseVectorVariant {
    List<int[]> indexToVal;
    
    SparseVectorVariant(int[] nums) {
        this.indexToVal = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indexToVal.add(new int[]{i, nums[i]});
            }
        }
    }

  public int dotProduct(SparseVectorVariant vec) {
        int sum = 0;
        
        // Always iterate the smaller vector to minimize total binary searches
        // AKA iterate smaller vector and binary search the larger vector
        if (indexToVal.size() < vec.indexToVal.size()) {
            for (int[] pair : indexToVal) {
                int index = pair[0];
                int value = pair[1];
                sum += value * binarySearch(vec.indexToVal, index);
            }
        } else {
            for (int[] pair : vec.indexToVal) {
                int index = pair[0];
                int value = pair[1];
                sum += value * binarySearch(indexToVal, index);
            }
        }
        
        return sum;
    }
    
    private int binarySearch(List<int[]> indexToVal, int targetIndex) {
        int left = 0;
        int right = indexToVal.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (indexToVal.get(mid)[0] == targetIndex) {
                return indexToVal.get(mid)[1];
            }
            if (targetIndex > indexToVal.get(mid)[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}

// Your SparseVectorVariant object will be instantiated and called as such:
// SparseVectorVariant v1 = new SparseVectorVariant(nums1);
// SparseVectorVariant v2 = new SparseVectorVariant(nums2);
// int ans = v1.dotProduct(v2);

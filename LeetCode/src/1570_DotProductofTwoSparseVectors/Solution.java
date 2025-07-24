/*
        * time complexity  = O(L1) + O(L2); non zero values in each list
        * space complexity = O(L1) + O(L2)
*/
class SparseVector {
    List<int[]> indexToVal;
    
    SparseVector(int[] nums) {
        this.indexToVal = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indexToVal.add(new int[]{i, nums[i]});
            }
        }
    }
    
    public int dotProduct(SparseVector vec) {
        int i = 0;
        int j = 0;
        int sum = 0;

        while (i < indexToVal.size() && j < vec.indexToVal.size()) { 
            if (indexToVal.get(i)[0] == vec.indexToVal.get(j)[0]) {
                sum += indexToVal.get(i)[1] * vec.indexToVal.get(j)[1];
                i++;
                j++;
            } else if (indexToVal.get(i)[0] > vec.indexToVal.get(j)[0]) {
                j++;
            } else {
                i++;
            }
        }

        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

/*
        * time complexity  = O(n + m + p)
        * space complexity = O(n + m + p)

        * VARIANT: What if you had to merge 3 sorted integer lists? Duplicates in the merged list is allowed.
*/
class Solution {
    public int[] mergeThreeSortedArrays(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < arr1.length || j < arr2.length || k < arr3.length) {
            int val1 = (i < arr1.length) ? arr1[i] : Integer.MAX_VALUE;
            int val2 = (j < arr2.length) ? arr2[j] : Integer.MAX_VALUE;
            int val3 = (k < arr3.length) ? arr3[k] : Integer.MAX_VALUE;
            
            int minVal = Math.min(Math.min(val1, val2), val3);

            list.add(minVal);
            
            if(val1 == minVal) {
                i++;
            } else if(val2 == minVal) {
                j++;
            } else {
                k++;
            }
        }
        
        int[] result = new int[list.size()];
        for(int idx = 0; idx < list.size(); idx++) {
            result[idx] = list.get(idx);
        }
        return result;
    }
}

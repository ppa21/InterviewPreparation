/*
        * time complexity  = O(m + n); m = listA.length / 2, n = listB.length
        * space complexity = O(1)
*/
public class Solution {
    public void mergeVectors(int[] listA, int[] listB) {
        // listA has DOUBLE the size needed: first half is data, second half is 0s (ignored/overwritten)
        // We merge into listA itself, working backwards to avoid overwriting unprocessed data
        
        int a = (listA.length / 2) - 1;  // Last actual element in listA (first half), before 0s
        int b = listB.length - 1;        // Last element in listB
        int i = listA.length - 1;        // Last position in listA (start filling from here)
        
        while (b >= 0) {
            if (a >= 0 && listA[a] >= listB[b]) {
                listA[i] = listA[a];
                a--;
            } else {
                listA[i] = listB[b];
                b--;
            }
            i--;
        }
    }
    
    // Time Complexity: O(n + m) where n = listA.length/2, m = listB.length
    // Space Complexity: O(1) - only using a few pointer variables
}

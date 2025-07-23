/*
        * time complexity  = O(n + m)
        * space complexity = O(n + m)

        * Variant: What if you had to merge two interval lists instead of one? A and B are already sorted
*/
public int[][] mergeTwoLists(int[][] A, int[][] B) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int j = 0;
    
    while (i < A.length && j < B.length) {
        int[] curr;
        if (A[i][0] < B[j][0]) {
            curr = A[i];
            i++;
        } else {
            curr = B[j];
            j++;
        }
        
        tryMerge(result, curr);
    }
    
    // Handle remaining intervals from A
    while (i < A.length) {
        tryMerge(result, A[i]);
        i++;
    }
    
    // Handle remaining intervals from B  
    while (j < B.length) {
        tryMerge(result, B[j]);
        j++;
    }
    
    return result.toArray(new int[result.size()][]);
}

private void tryMerge(List<int[]> result, int[] curr) {
    if (result.isEmpty() || result.get(result.size() - 1)[1] < curr[0]) { // last[1] < curr[0] --> no conflict
        result.add(curr);
    } else {
        result.get(result.size() - 1)[1] = Math.max(curr[1], result.get(result.size() - 1)[1]);
    }
}

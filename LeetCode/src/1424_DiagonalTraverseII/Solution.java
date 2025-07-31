/*
        * time complexity  = O(n)
        * space complexity = O(sqrt(n))

        * rotate matrix 45deg and you pretty get a tree structure and 
          you can do level order traversal
*/
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
    
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
        
            list.add(nums.get(row).get(col)); // list.add(nums[row][col])
        
            // Add next row (only when col == 0 to avoid duplicates)
            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new int[]{row + 1, col});
            }
        
            // Add next column
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col + 1});
            }
        }
    
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

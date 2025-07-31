/*
        * time complexity  = O(n)
        * space complexity = O(sqrt(n))

        * rotate matrix 45deg and you get a tree structure and 
          you can do level order traversal
        
        * VARIANT: What if you had to return a list of the anti-diagonal traversal?
*/
class Solution {
    public int[][] findAntiDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
            
                currLevel.add(nums.get(row).get(col)); // currLevel.add(nums[row][col])
            
                // Add next column first (different order from original)
                if (col + 1 < nums.get(row).size()) {
                    queue.offer(new int[]{row, col + 1});
                }
                
                // Add next row (only when col == 0 to avoid duplicates)
                if (col == 0 && row + 1 < nums.size()) {
                    queue.offer(new int[]{row + 1, col});
                }
            }
            
            list.add(currLevel);
        }

        return list.toArray(new int[list.size()][]);
    }
}

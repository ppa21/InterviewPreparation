/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
        * time complexity  = O(n)
        * space complexity = O(n)
*/
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        /* 
                * Input  -> [3,9,8,4,0,1,7]
                * Output -> [[4],[9],[3,0,1],[8],[7]]
                
                * columnValues:
                * col    -> [values at that col]
                * [-2]   -> [4]
                * [-1]   -> [9]
                * [0]    -> [3, 0, 1]; left to right
                * ...
        */      
        Map<Integer, List<Integer>> columnValues = new HashMap<>();

        // [TreeNode, column number]
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int minCol = 0;
        int maxCol = 0;

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int col = p.getValue();

            if (!columnValues.containsKey(col)) {
                columnValues.put(col, new ArrayList<>());
            }
            columnValues.get(col).add(node.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) {
                q.add(new Pair<>(node.left, col - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, col + 1));
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            result.add(columnValues.get(i));
        }

        return result;
    }
}

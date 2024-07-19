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
    * Bottom Up Approach
        * Each node visited at most 1 time
    * Time Complexity  = O(n); n = number of nodes
    * Space Complexity = O(h); h = height of the tree AND space will be taken by stack
 */
class Solution {
    private int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        result = Math.max(result, left + right);

        return Math.max(left, right) + 1;
    }
}

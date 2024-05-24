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
    * Time Complexity  = O(n); n = number of nodes; because we're checking each node's value against max
    * Space complexity = O(n); n = height of the tree; worst case
 */ 
class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, -99999);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int result = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        result += dfs(root.left, Math.max(root.val, max));
        result += dfs(root.right, Math.max(root.val, max));

        return result;
    }
}

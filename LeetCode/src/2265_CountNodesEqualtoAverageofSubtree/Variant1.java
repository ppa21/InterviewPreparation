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
        * time complexity  = O(n); n = nodes
        * space complexity = O(h); h = height of the tree due to recursion stack

        * VARIANT = return a boolean whether the value of every node is equal to the average of values in its subtree
 */
class Solution {
    
    public boolean isSubtreeAverage(TreeNode root) {
        int[] result = postorder(root);
        return result[1] != -1;
    }
    
    private int[] postorder(TreeNode currNode) {
        if (currNode == null) {
            return new int[]{0, 0}; // {sum, nodes}
        }
        
        int[] left = postorder(currNode.left);
        int[] right = postorder(currNode.right);
        
        // If any subtree fails the condition, propagate the failure
        if (left[1] == -1 || right[1] == -1) {
            return new int[]{-1, -1};
        }
        
        int sum = left[0] + right[0] + currNode.val;
        int nodes = left[1] + right[1] + 1;
        
        // If current node doesn't satisfy the average condition, mark as failed
        if (sum / nodes != currNode.val) {
            return new int[]{-1, -1};
        }
        
        return new int[]{sum, nodes};
    }
}

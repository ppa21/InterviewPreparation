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
 */
class Solution {
    private int count = 0;
    
    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return count;
    }
    
    private int[] postorder(TreeNode currNode) {
        if (currNode == null) {
            return new int[]{0, 0}; // {sum, nodes}
        }
        
        int[] left = postorder(currNode.left);
        int[] right = postorder(currNode.right);
        
        int sum = left[0] + right[0] + currNode.val;
        int nodes = left[1] + right[1] + 1;
        
        if (sum / nodes == currNode.val) {
            count++;
        }
        
        return new int[]{sum, nodes};
    }
}

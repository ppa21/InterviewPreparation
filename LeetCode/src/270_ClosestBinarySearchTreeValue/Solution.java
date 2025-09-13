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
        * time complexity =  O(h); h = height of BST
        * space complexity = O(1)
*/
class Solution {
    public int closestValue(TreeNode root, double target) {
        double closestDistance = Double.MAX_VALUE;
        int result = 0;
        
        while (root != null) {
            double distance = Math.abs(root.val - target);
            if (distance < closestDistance ||
                (distance == closestDistance && root.val < result)) {
                closestDistance = distance;
                result = root.val;
            }
            
            if (distance == 0) {
                return root.val;
            }
            
            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        
        return result;
    }
}

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

        * VARIANT = What if the target parameter was given as an integer, not a double?
*/
class Solution {
    public int closestValue(TreeNode root, int target) {
        int closestDistance = Integer.MAX_VALUE;
        int result = 0;
        
        while (root != null) {
            int distance = Math.abs(root.val - target);
            if (distance < closestDistance ||
                (distance == closestDistance && root.val < result)) {
                closestDistance = distance;
                result = root.val;
            }
            
            if (distance == 0) {
                return root.val;
            }
            
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return result;
    }
}

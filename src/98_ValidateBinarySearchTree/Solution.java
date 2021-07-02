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
class Solution {
    /*
                                5
                              /   \
          -inf < 3 < 5       3     7       5 < 7 < +inf
                                  /  \
                                 4   8
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer left, Integer right) {
        if(root == null) {
            return true;
        } else if((left != null && root.val <= left) || (right != null && root.val >= right)) {
            return false;
        } else {
            return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
        }
    }
}
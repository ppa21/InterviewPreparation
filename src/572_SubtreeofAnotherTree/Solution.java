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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        } else if(isSameTree(root, subRoot)) {      // for the level we're on, does subRoot appear in root?
            return true;
        } else {        // move to the next level, and ask the same question
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return root == subRoot;
        }

        if(root.val != subRoot.val) {
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
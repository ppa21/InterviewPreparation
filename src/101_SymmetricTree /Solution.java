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
    public boolean isSymmetric(TreeNode root) {
        /*
            If root is null, it doesn't have any children.
            So, the mirror of null, is null. That means it's
            symmetric -> return true
         */
        if(root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    /*
        Input: root = [1,2,2,3,4,4,3]
        Output: true
                            1
                          /   \
                         2    2
                       /  \  / \
                      3   4 4  3

        Input: root = [1,2,2,null,3,null,3]
        Output: false
                            1
                          /   \
                         2    2
                          \    \
                          3    3
        For this to be true, the tree would have to look like this:
                            1
                          /   \
                         2    2
                          \  /
                          3 3
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        /*
            If left is null or right is null, you want the other one
            to be null as well for it to be symmetric. So, you
            compare left and right (left == right), and return the
            output of it.
                * left = null
                * right = 5
                    * return left == right -> false
                * left = 3
                * right = 3
                    * return left == right -> true
         */
        if(left == null || right == null) {
            return left == right;
        }

        /*
            If values are not equal -> return false since the main tree
            is not symmetric (AKA when left is mirrored, it doesn't produce right)
         */
        if(left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
            * Time Complexity:     O(logn) ---> We're ONLY visiting ONE NODE per LEVEL ---> The HEIGHT of the TREE
            * Space Complexity:    O(1) ---> No Data Structure used for storage
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                /*
                        * We've reached a common node and it splits from there
                            * Common node IS the lowest common ancestor
                                * Because it splits from that node

                 */
                break;
            }
        }

        return root;
    }
}
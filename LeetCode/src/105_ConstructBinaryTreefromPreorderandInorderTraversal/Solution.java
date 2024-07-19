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
            * Time Complexity: O(n) ---> We're only going through both the arrays once
            * Space Complexity: O(n) ---> We're using a HashMap
     */
    /*
            * 2 rules to remember:
                1) First element of preorder ---> ALWAYS the ROOT
                2) Find the value of the FIRST ELEMENT of preorder (AKA the root) IN inorder
                    * WHAT'S ON THE LEFT OF THAT VALUE IN inorder ---> will go on the LEFT SUBTREE
                    * WHAT'S ON THE RIGHT OF THAT VALUE IN inorder ---> will go on the RIGHT SUBTREE

            *                       3
                                  /   \
                                 9    20
                                    /   \
                                   15   7
                    * preorder = [3, 9, 20, 15, 7] ---> RULE 1: 3 is the ROOT
                    * inorder = [9, 3, 15, 20, 7] ---> RULE 2: LEFT subtree = 9, RIGHT subtree = 15, 20, 7
     */

    private Map<Integer, Integer> map = new HashMap();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;

        if(root == null) {
            return null;
        }

        if(start == end) {
            return root;
        }

        int index = map.get(root.val);

        root.left = buildTree(preorder, inorder, start, index - 1);
        root.right = buildTree(preorder, inorder, index + 1, end);

        return root;
    }
}
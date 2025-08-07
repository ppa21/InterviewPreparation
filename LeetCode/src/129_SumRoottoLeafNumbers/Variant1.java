/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree

        * Variant: What if you nodes could be larger than 9?
*/
class Solution {
    private int rootToLeaf;
    
    public int sumNumbers(TreeNode root) {
        rootToLeaf = 0;
        preorder(root, 0);
        return rootToLeaf;
    }
    
    private void preorder(TreeNode node, int currNumber) {
        if (node != null) {
            int digits = String.valueOf(node.val).length();
            int multiplier = (int)Math.pow(10, digits);
            currNumber = currNumber * multiplier + node.val;
            if (node.left == null && node.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(node.left, currNumber);
            preorder(node.right, currNumber);
        }
    }
}

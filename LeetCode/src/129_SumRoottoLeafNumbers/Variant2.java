/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree
*/
class Solution {
    private int rootToLeaf;
    
    public int sumNumbers(TreeNode root) {
        rootToLeaf = 0;
        preorder(root, 0, 0);
        return rootToLeaf;
    }
    
    private void preorder(TreeNode node, int currNumber, int numNegatives) {
        if (node != null) {
            currNumber = currNumber * 10 + Math.abs(node.val);
            if (node.val < 0) {
                numNegatives++;
            }
            if (node.left == null && node.right == null) {
                int sign = (numNegatives % 2 == 1) ? -1 : 1;
                rootToLeaf += currNumber * sign;
            }
            preorder(node.left, currNumber, numNegatives);
            preorder(node.right, currNumber, numNegatives);
        }
    }
}

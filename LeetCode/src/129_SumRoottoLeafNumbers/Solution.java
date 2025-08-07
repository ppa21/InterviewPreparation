/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree
*/
class Solution {
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return totalSum;
    }
    
    private void preorder(TreeNode node, int currSum) {
        if (node != null) {
            currSum = currSum * 10 + node.val;
            if (node.left == null && node.right == null) {
                totalSum += currSum;
            }
            preorder(node.left, currSum);
            preorder(node.right, currSum);
        }
    }
}

/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree

        * Variant: What if you nodes could be larger than 9?
*/
class Solution {
    private int totalSum;
    
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        preorder(root, 0);
        return totalSum;
    }
    
    private void preorder(TreeNode node, int currSum) {
        if (node != null) {
            int digits = String.valueOf(node.val).length();
            int multiplier = (int)Math.pow(10, digits);
            currSum = currSum * multiplier + node.val;
            if (node.left == null && node.right == null) {
                totalSum += currSum;
            }
            preorder(node.left, currSum);
            preorder(node.right, currSum);
        }
    }
}

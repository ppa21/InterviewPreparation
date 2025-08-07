/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree
*/
class Solution {
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) { 
        preorder(root, 0, 0);
        return totalSum;
    }
    
    private void preorder(TreeNode node, int currSum, int numNegatives) {
        if (node != null) {
            currSum = currSum * 10 + Math.abs(node.val);
            if (node.val < 0) {
                numNegatives++;
            }
            if (node.left == null && node.right == null) {
                int sign = (numNegatives % 2 == 1) ? -1 : 1;
                totalSum += currSum * sign;
            }
            preorder(node.left, currSum, numNegatives);
            preorder(node.right, currSum, numNegatives);
        }
    }
}

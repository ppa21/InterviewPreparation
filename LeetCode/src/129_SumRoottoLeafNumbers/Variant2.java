/*
        * time complexity  = O(n); n = number of nodes
        * space complexity = O(h); h = height of the tree

        * VARIANT: What if you had to ignore negative signs in your calculations until
          you reached a leaf node, and instead, only consider signage if a root-to-leaf path is
          a "negative path"?
*/
class Solution {
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) { 
        preorder(root, 0, 0);
        return totalSum;
    }
    
    private void preorder(TreeNode node, int currSum, int numNegatives) {
        if (node != null) {
            if (node.val < 0) {
                numNegatives++;
            }

            currSum = currSum * 10 + Math.abs(node.val);
            if (node.left == null && node.right == null) {
                int sign = (numNegatives % 2 == 1) ? -1 : 1;
                totalSum += currSum * sign;
            }
            preorder(node.left, currSum, numNegatives);
            preorder(node.right, currSum, numNegatives);
        }
    }
}

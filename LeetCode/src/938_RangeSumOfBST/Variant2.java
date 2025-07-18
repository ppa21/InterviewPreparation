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

/*
       * Time Complexity:  O(N) preprocessing, O(log N) per query
       * Space Complexity: O(N)
       
       * At most 10^4 calls will be made to rangeSumBST 
 */
class Solution {
    private List<Integer> vals;        // inorder list; left -> root.val -> right
    private List<Integer> prefixSums;
    
    public Solution(TreeNode root) {
        vals = new ArrayList<>();
        prefixSums = new ArrayList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            // Build sorted array and prefix sums during traversal
            vals.add(root.val);
            if (prefixSums.isEmpty()) {
                prefixSums.add(root.val);
            } else {
                prefixSums.add(prefixSums.get(prefixSums.size() - 1) + root.val);
            }
            
            root = root.right;
        }
    }
    
    // Find rightmost position where vals[i] <= upper
    // Returns index of last element <= upper
    private int findRightBoundary(int left, int right, int upper) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
          
            if (vals.get(mid) <= upper) {
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }
        return right; // val(right index) <= upper
    }
    
    // Find leftmost position where vals[i] >= lower  
    // Returns index of first element >= lower
    private int findLeftBoundary(int left, int right, int lower) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
          
            if (vals.get(mid) >= lower) {
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }
        return left; // val(left index) >= lower
    }
    
    // Main method - same logic as C++ calculate()
    public int rangeSumBST(int lower, int upper) {
        int rightBoundary = findRightBoundary(0, vals.size() - 1, upper);
        int leftBoundary = findLeftBoundary(0, vals.size() - 1, lower);
        
        if (leftBoundary == 0) {
            return prefixSums.get(rightBoundary);
        }
        return prefixSums.get(rightBoundary) - prefixSums.get(leftBoundary - 1);
    }
}

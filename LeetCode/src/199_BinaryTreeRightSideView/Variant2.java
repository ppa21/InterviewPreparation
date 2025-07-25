/*
        * Time Complexity  = O(n); n = number of nodes
        * Space Complexity = O(n); n = number of nodes

        * Variant: What if you had to print to console the left and right side views?
          No other change from Variant1.java
*/
class Solution {
    public void printLeftAndRightSideViews(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                
                if (i == 0) {
                    leftSide.add(node.val);
                }
                
                if (i == size - 1) {
                    rightSide.add(node.val);
                }
                
                if (node.left != null) {
                    q.add(node.left);
                }
              
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        
        // bottom to top
        // root added here, i = 0
        for (int i = leftSide.size() - 1; i >= 0; i--) {
            System.out.println(leftSide.get(i) + " "); 
        }
        
        // top to bottom
        for (int i = 1; i < rightSide.size(); i++) {
            System.out.println(rightSide.get(i) + " "); 
        }
    }
}

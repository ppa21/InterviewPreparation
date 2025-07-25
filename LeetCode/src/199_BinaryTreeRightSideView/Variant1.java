/*
        * Time Complexity  = O(n); n = number of nodes
        * Space Complexity = O(n); n = number of nodes

        * Variant: What if you had to return both the left and right side views of a binary tree? 
          left side:  bottom to top
          right side: top to bottom
          root can only be added to one side, we'll add root to the left side
*/
class Solution {
    public List<Integer> getLeftRightSideViews(TreeNode root) {
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
        
        List<Integer> result = new ArrayList<>();
        
        // bottom to top
        // root added here, i = 0
        for (int i = leftSide.size() - 1; i >= 0; i--) {
            result.add(leftSide.get(i));
        }
        
        // top to bottom
        for (int i = 1; i < rightSide.size(); i++) {
            result.add(rightSide.get(i));
        }
        
        return result;
    }
}

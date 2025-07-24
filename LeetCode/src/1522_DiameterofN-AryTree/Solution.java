/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

 /*
    * Bottom Up Approach
        * Each node visited at most 1 time
    * Time Complexity  = O(n); n = number of nodes
    * Space Complexity = O(h); h = height of the tree AND space will be taken by stack

    * Variant: What if you had to find the diameter of an N-ary tree?
      Leetcode 543. Diameter of Binary Tree
 */
class Solution {
    private int result = Integer.MIN_VALUE;

    public int diameter(Node root) {
        dfs(root);

        return result;    
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }

        int maxHeight = 0;
        int secondMaxHeight = 0;

        for (Node child : root.children) {
            int height = dfs(child);

            if (height > maxHeight) {
                secondMaxHeight = maxHeight;
                maxHeight = height;
            } else if (height > secondMaxHeight) {
                secondMaxHeight = height;
            }
        }

        result = Math.max(result, maxHeight + secondMaxHeight);

        return maxHeight + 1;
    }
}

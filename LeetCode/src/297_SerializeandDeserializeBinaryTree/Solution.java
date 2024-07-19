/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    /*
            * Time Complexity: O(n + m) ---> n = number of nodes, m = number of edges ---> O(n)
                * Preorder traversal (DFS)
                    * Visiting each node and edge ESSENTIALLY once
                        * O(n)
            * Space Complexity: O(n + m) ---> O(n) ---> Because of the QUEUE
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "null";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));

        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String s = queue.remove();

        if(s.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = dfs(queue);
        node.right = dfs(queue);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
/*
        * time complexity  = O(nlogn)
        * space complexity = O(n)
*/
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<Pair<TreeNode, Integer>>> colToNodeAndRow = new HashMap<>();
        int[] bounds = levelOrderTraversal(root, colToNodeAndRow);

        for (int i = bounds[0]; i <= bounds[1]; i++) {
            // put sorting here if required i.e. 987. Vertical Order Traversal of a Binary Tree
            List<Pair<TreeNode, Integer>> column = colToNodeAndRow.get(i);
            column.sort((a, b) -> {
                if (a.getValue().equals(b.getValue())) // Are they in the SAME row?
                    return a.getKey().val - b.getKey().val; // YES: sort by node value
                return a.getValue() - b.getValue(); // NO: sort by row number
            });

            List<Integer> currCol = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : colToNodeAndRow.get(i)) {
                currCol.add(pair.getKey().val);
            }
            result.add(currCol);
        }

        return result;
    }

    private int[] levelOrderTraversal(TreeNode root, Map<Integer, List<Pair<TreeNode, Integer>>> colToNodeAndRow) {
        int leftmostCol = 0;
        int rightmostCol = 0;
        Queue<NodeMetadata> q = new LinkedList<>();
        q.add(new NodeMetadata(0, 0, root));

        while (!q.isEmpty()) {
            NodeMetadata metadata = q.poll();
            int row = metadata.row;
            int col = metadata.col;
            TreeNode node = metadata.node;

            if (!colToNodeAndRow.containsKey(col)) {
                colToNodeAndRow.put(col, new ArrayList<>());
            }
            colToNodeAndRow.get(col).add(new Pair<>(node, row));

            leftmostCol = Math.min(leftmostCol, col);
            rightmostCol = Math.max(rightmostCol, col);

            if (node.left != null) {
                q.add(new NodeMetadata(row + 1, col - 1, node.left));
            }
            if (node.right != null) {
                q.add(new NodeMetadata(row + 1, col + 1, node.right));
            }
        }

        return new int[]{leftmostCol, rightmostCol};
    }

    class NodeMetadata {
        int row;
        int col;
        TreeNode node;

        NodeMetadata(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
}

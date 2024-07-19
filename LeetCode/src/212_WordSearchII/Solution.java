class Solution {
    /*
            * Time Complexity: O(m * n * wl * (4 ^ wl)); m = number of rows in board, n = number of columns in board, wl = AVERAGE word length of WORDS in words array
            * Space Complexity: O(k); k = length of all the WORDS in words array ADDED together
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();

        Node root = buildNode(words);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private Node buildNode(String[] words) {
        Node root = new Node();

        for(String word : words) {
            Node curr = root;

            for(char c : word.toCharArray()) {
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }

                curr = curr.children[c - 'a'];
            }

            curr.word = word;
        }

        return root;
    }

    private void dfs(char[][] board, int i, int j, Node root, List<String> result) {
        char c = board[i][j];
        if(c == ' ' || root.children[c - 'a'] == null) {
            return;
        }

        root = root.children[c - 'a'];
        if(root.word != null) {
            result.add(root.word);
            root.word = null;       // to remove duplication
        }

        board[i][j] = ' ';

        if(i > 0) {
            dfs(board, i - 1, j, root, result);
        }

        if(j > 0) {
            dfs(board, i, j - 1, root, result);
        }

        if(i < board.length - 1) {
            dfs(board, i + 1, j, root, result);
        }

        if(j < board[i].length - 1) {
            dfs(board, i, j + 1, root, result);
        }

        board[i][j] = c;
    }

    private class Node {
        private String word;
        private Node[] children;

        public Node() {
            this.word = null;
            this.children = new Node[26];
        }
    }
}
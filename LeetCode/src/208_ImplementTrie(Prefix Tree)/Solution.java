class Trie {
    /*
            * Time Complexity: insert, search, startsWith = O(m) ---> m = # of characters in the word
            * Space Complexity: insert = O(m); search & startsWith = O(1)
     */
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }

            curr = curr.children[c - 'a'];
        }

        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getNode(word);

        return node != null && node.isWord == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = getNode(prefix);

        return node != null;
    }

    private Node getNode(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null) {
                return null;
            }

            curr = curr.children[c - 'a'];
        }

        return curr;
    }

    public class Node {
        private char c;
        private boolean isWord;
        private Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// Solution similar to 208. Implement Trie (Prefix Tree)
/*
        * Time Complexity:
                        * add = O(M) ---> M = word length
                        * search = O(N * M) ---> total words in Node
        * Space Complexity:
                        * O(N * M)
                        * search = O(N * (26 ^ M))
 */
class WordDictionary {

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, Node curr, int index) {
        if(index == word.length()) {
            return curr.isWord;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(curr.children[i] != null && find(word, curr.children[i], index + 1)) {
                    return true;
                }
            }

            return false;
        } else {
            return curr.children[c - 'a'] != null && find(word, curr.children[c - 'a'], index + 1);
        }
    }

    private class Node {
        private char c;
        private boolean isWord;
        private Node[] children;

        public Node(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
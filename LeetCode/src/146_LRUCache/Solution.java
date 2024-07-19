/*
    * Time Complexity  = O(1); get() and put() are both constant time
    * Space Complexity = O(capacity)
*/
class LRUCache {

    private Map<Integer, Node> cache; // The cache, stored as a HashMap
    private int capacity; // The maximum capacity of the cache

    // BOTH ARE DUMMY NODES
    // this.left.next  ---> LRU
    // this.right.prev ---> MRU
    private Node left;  // The leftmost (least recently used) node
    private Node right; // The rightmost (most recently used) node

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        cache = new HashMap<>();  

        this.left = new Node(0, 0); 
        this.right = new Node(0, 0);

        // doubly linked list so they're connected to eachother
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); // since it was just accessed so it's MRU
            insert(cache.get(key)); 
            return cache.get(key).val; 
        } else {
            return -1; 
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) { 
            remove(cache.get(key));  
        }
        cache.put(key, new Node(key, value));  
        insert(cache.get(key));  

        if (cache.size() > capacity) {  
            Node lru = this.left.next;  
            remove(lru); 
            cache.remove(lru.key);  
        }
    }

    // Method to remove a node from the list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // Method to insert a node at the rightmost position
    // this.right == DUMMY NODE
    // so insert at this.right.prev
    public void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    // Definition for the linked list node
    private class Node {

        private int key; // The key of the node
        private int val; // The value of the node

        Node next; // The next node in the list
        Node prev; // The previous node in the list

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

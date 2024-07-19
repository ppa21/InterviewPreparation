class MyHashSet {
    private final int SIZE = 100;

    private List<List<Integer>> parent;

    /** Initialize your data structure here. */
    public MyHashSet() {
        parent = new ArrayList<>(SIZE);

        for(int i = 0; i < SIZE; i++) {
            parent.add(null);
        }
    }

    public void add(int key) {
        int index = key % SIZE;
        List<Integer> child = parent.get(index);

        if(child == null) {
            List<Integer> list = new LinkedList();
            list.add(key);
            parent.set(index, list);
        } else {
            if(!child.contains(key)) {
                child.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = key % SIZE;
        List<Integer> child = parent.get(index);

        if(child != null) {
            child.remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % SIZE;
        List<Integer> child = parent.get(index);

        return child != null && child.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
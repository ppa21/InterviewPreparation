/*
        * time complexity  = O(n); n = total numbers in the nested structure
        * space complextiy = O(w); w = max width of any level

        * VARIANT: What if you had to define your own schema for NestedList and implement BFS?
*/
class Solution {
    public int depthSum(List<Object> list) {
        Queue<Object> queue = new LinkedList<>(list);
        int level = 1;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object obj = queue.poll();
                if (obj instanceof Integer) {
                    sum += (Integer) obj * level;
                } {
                    queue.addAll(((Object) obj).value);
                }
            }
            level++;
        }
        return sum;
    }

    class Object {
        List<Object> list;
        
        public Object() {
            this.list = new ArrayList<>();
        }
    }
}

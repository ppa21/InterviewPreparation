/*
        * time complexity  = O(n); n = total numbers in the nested structure
        * space complextiy = O(w); w = max width of any level

        * VARIANT: What if you had to define your own schema for NestedList and implement BFS?
*/
class Solution {
    public int depthSum(List<Object> objs) {
        Queue<Object> queue = new LinkedList<>(objs);
        int level = 1;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object obj = queue.poll();
                if (obj instanceof Integer) {
                    sum += (Integer) obj * level;
                } else if (obj instanceof ObjectNode) {
                    queue.addAll(((ObjectNode) obj).value);
                }
            }
            level++;
        }
        return sum;
    }
}

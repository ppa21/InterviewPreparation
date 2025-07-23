/*
        * time complexity  = O(n); n = total numbers in the nested structure
        * space complextiy = O(d); d = max depth

        * VARIANT: What if you had to define your own schema for NestedList and implement DFS?
*/
class Solution {
    public int depthSum(List<Object> list) {
        return dfs(list, 1);
    }
    
    private int dfs(List<Object> list, int depth) {
        int sum = 0;
        for (Object o : list) {
            if (o instanceof Integer) {
                sum += (Integer) o * depth;
            } else {
                sum += dfs(((Object) o).list, depth + 1);
            }
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

/*
        * time complexity  = O(n); n = total numbers in the nested structure
        * space complextiy = O(d); d = max depth

        * VARIANT: What if you had to define your own schema for NestedList and implement DFS?
*/
class Solution {
    public int depthSum(List<Object> objs) {
        return dfs(objs, 1);
    }
    
    private int dfs(List<Object> objs, int depth) {
        int sum = 0;
        for (Object obj : objs) {
            if (obj instanceof Integer) {
                sum += (Integer) obj * depth;
            } else {
                sum += dfs(((Object) obj).value, depth + 1);
            }
        }
        return sum;
    }

  class Object {
        List<Object> value;
        
        public Object() {
            this.value = new ArrayList<>();
        }
    }
}

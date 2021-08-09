class Solution {
    /*
            * Time Complexity: O(n) ---> n = the size of nums array
            * Space Complexity: O(n)
     */


    // Bucket Sort
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
                * List<int[]> list
                    * List of int[]

                * List<Integer>[] array
                    * Array of List<Integer>
         */
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : map.keySet()) {
            int freq = map.get(key);

            if(bucket[freq] == null) {
                List<Integer> list = new ArrayList();
                list.add(key);

                bucket[freq] = list;
            } else {
                bucket[freq].add(key);
            }
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) {
                for(int num : bucket[i]) {
                    result[index] = num;
                    index++;

                    if(index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
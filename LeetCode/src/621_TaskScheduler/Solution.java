/*
    * Time Complexity  = O(nlogk); n = length of tasks[]; k = elements in maxHeap --> 26 max in this case
        * So, it could be considered 
            * O(n)
    * Space Complexity = O(n)
        * but in this case, since it's only max 26 characters
            * it could be considered 
                * O(1)
*/ 
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        /*
            * instead of storing letters from tasks[], we store the frequency of how many times a certain letter is used
            * and then we sort it by most frequent AKA descending
                * so that there's as little down time as possible
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /*
            * val taken out from maxHeap
                * val - 1 --> to reduce it's frequency
                    * place val in q
                        * key = val
                        * value = when it'll be available next
                            * time + n 
                                * n = cooling time AKA idle time 
        */
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        // to store frequency of letters from tasks[]
        int[] arr = new int[26];

        int time = 0;

        for (char c : tasks) {
            arr[c - 'A']++;
        }

        for (int val : arr) {
            if (val > 0) {
                maxHeap.add(val);
            }
        }

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int val = maxHeap.remove();
                val--;

                if (val > 0) {
                    q.add(new Pair(val, time + n));
                }
            }

            /*
                * once q's top element's value (time + n; AKA when that task can be used again) is equal to CURRENT TIME
                    * q.peek().getValue() == time
                        * we remove it from q and get its key
                            * and then we insert that back into maxHeap
                                * maxHeap.add(q.remove().getKey())
            */
            if (!q.isEmpty() && q.peek().getValue() == time) {
                maxHeap.add(q.remove().getKey());
            }
        }

        return time;
    }
}

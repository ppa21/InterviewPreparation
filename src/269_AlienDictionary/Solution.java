public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */

    /*
            * Time Complexity: O(NM)
                * N = length of words[]
                * M = length of the largest word in words[]
            * Space Complexity: O(N)
     */
    public String alienOrder(String[] words) {
        // Write your code here
        int[] indegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.put(c, new ArrayList());
            }
        }

        // ["wrt","wrf","er","ett","rftt"]
        for(int i = 0; i < words.length - 1; i++) {
            String start = words[i];        // wrt
            String end = words[i + 1];      // wrf

            if(start.length() > end.length() && start.startsWith(end)) {
                return "";
            }

            int len = Math.min(start.length(), end.length());       // min(3, 3) -> 3
            for(int j = 0; j < len; j++) {
                char startChar = start.charAt(j);       // same wr -> difference: t
                char endChar = end.charAt(j);           // same wr -> difference: f

                if(startChar != endChar) {              // t != f
                    graph.get(startChar).add(endChar);  // t -> f
                    indegree[endChar - 'a']++;          // indegree[5] = 1

                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList();

        for(char c : graph.keySet()) {
            if(indegree[c - 'a'] == 0) {
                q.add(c);
            }
        }

        while(!q.isEmpty()) {
            char startChar = q.poll();
            sb.append(startChar);

            for(char endChar : graph.get(startChar)) {
                indegree[endChar - 'a']--;

                if(indegree[endChar - 'a'] == 0) {
                    q.add(endChar);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
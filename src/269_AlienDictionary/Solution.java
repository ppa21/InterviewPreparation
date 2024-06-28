/*
    * Time Complexity  = O(n); n = total length of all the words combined; ["wrt", "wrf", "er", "ett", "rftt"] = 15 = n
    * Space Complexity = O(n); amount of space required by the algorithm grows linearly with the size of the input
*/
public class Solution {
    private Map<Character, Set<Character>> adj = new HashMap<>(); // adjacency list
    private Map<Character, Boolean> visited = new HashMap<>(); // visited nodes
    private List<Character> result = new ArrayList<>();

    public String foreignDictionary(String[] words) {
        // Initialize adjacency list
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c)) {
                    adj.put(c, new HashSet<>());
                }
            }
        }

        // Build adjacency list
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];     // w1 = "wrt"
            String w2 = words[i + 1]; // w2 = "wrf"
            int minLen = Math.min(w1.length(), w2.length()); // e.g., minLen=3
            
            /*
                * If w1 is longer than w2 and they share the same prefix, it's an invalid scenario.
                * For example, w1="wrt", w2="wr", it's invalid because "wrt" should come after "wr" in the dictionary.
            */
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) { // e.g., 't' != 'f'
                    adj.get(w1.charAt(j)).add(w2.charAt(j)); // Add 'f' to the adjacency list of 't'
                    break;
                }
            }
        }

        // Post-order DFS
        for (char c : adj.keySet()) {
            // if there is a cycle, return empty string ""
            if (dfs(c)) {
                return "";
            }
        }

        // Reverse result list and convert to string
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        
        return sb.toString(); // e.g., "wertf"
    }

    // Post-order DFS
    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c); // if this node was visited, return its status
        }

        visited.put(c, true); // mark as visited

        for (char next : adj.get(c)) {
            if (dfs(next)) {
                return true; // return true if a cycle is detected
            }
        }

        visited.put(c, false); // remove from visited, indicating that all descendants have been visited and no cycle is detected
        result.add(c); // add to result list
        return false; // return false to indicate that no cycle is detected
    }
}

/*
        * time complexity  = O(n + m); n = size of s, m = size of order
        * space complexity = O(n); n = size of s
*/
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (char c : order.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            result.append(String.valueOf(c).repeat(freq));
            map.remove(c);
        }

        for (char c : map.keySet()) {
            int freq = map.get(c);
            result.append(String.valueOf(c).repeat(freq));
        }

        return result.toString();
    }
}

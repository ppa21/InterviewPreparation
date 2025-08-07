/*
        * time complexity  = O(n + m); n = size of s, m = size of order
        * space complexity = O(n); n = size of s

        * VARIANT: What happens if Meta once again announces their hatred for maps, and you had
*/
class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (char c : order.toCharArray()) {
            int freq = arr[c - 'a'];
            result.append(String.valueOf(c).repeat(freq));
            arr[c - 'a'] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int freq = arr[i];
            if (freq > 0) {
                result.append(String.valueOf((char) (i + 'a')).repeat(freq));
            }
        }

        return result.toString();
    }
}

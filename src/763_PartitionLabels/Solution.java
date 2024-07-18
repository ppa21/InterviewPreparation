class Solution {
    /*
        * Time Complexity  = O(n); n = length of s
        * Space Complexity = O(k); k = number of unique characters in s
    */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();  // key = character; value = last index of a character
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        // Initialize variables for the start and end of the current partition
        int startOfPartition = 0;
        int endOfPartition = 0;
        List<Integer> partitionLengths = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // Update the end of the partition if the current character's last index is larger
            endOfPartition = Math.max(endOfPartition, map.get(s.charAt(i)));

            // If the current index is the end of the partition, add the partition length to the result
            // and update the start of the next partition
            if (i == endOfPartition) {
                partitionLengths.add(endOfPartition - startOfPartition + 1); // + 1 because we want the LENGTH
                startOfPartition = i + 1;
            }
        }

        return partitionLengths;
    }
}

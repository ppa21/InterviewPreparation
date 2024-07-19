class Solution {
    /*
        * Time Complexity  = O(mlogm); m = number of unique cards
        * Space Complexity = O(m)
    */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        /*
            TreeMap is used because it keeps the keys in sorted order. 
            This is useful when we want to form straights, as we need to 
            start from the smallest card and check for consecutive cards. 
            A HashMap does not maintain any order of its keys.
        */
        TreeMap<Integer, Integer> map = new TreeMap<>();    // key = card; value = count of card
        for (int card: hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Try to form each straight starting from the smallest card
        while (map.size() > 0) {
            int first = map.firstKey();

            // Check if we can form a straight starting from 'first'
            // card == first = 2; groupSize = 3; card < first + groupSize -----> 2 < 2 + 3 -----> 2 < 5 -----> [2, 3, 4]
            for (int card = first; card < first + groupSize; card++) {
                if (!map.containsKey(card)) {
                    return false;
                }
                
                if (map.get(card) == 1) {
                    map.remove(card);
                } else {
                    map.put(card, map.get(card) - 1);
                }
            }
        }

        // If we can form all straights, return true
        return true;
    }
}

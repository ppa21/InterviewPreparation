class Solution {
    /*
        * Time Complexity  = O(n); n = size of triplets
        * Space Complexity = O(1)
    */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] greedy = new boolean[3];

        for (int[] triplet : triplets) {
            // Initialize a flag to check if any element in the triplet is greater than the corresponding element in the target
            boolean skip = false;

            // For each element in the triplet, if it's greater than the corresponding element in the target, set the flag to true
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    skip = true;
                    break;
                }
            }

            // If the flag is true, skip this triplet
            if (skip) {
                continue;
            }

            // For each element in the triplet, if it's equal to the corresponding element in the target, mark it as achievable
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    greedy[i] = true;
                }
            }
        }

        // If all elements of the target triplet are achievable, return true. Otherwise, return false.
        return greedy[0] && greedy[1] && greedy[2];
    }
}

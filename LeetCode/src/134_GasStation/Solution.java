class Solution {
    /*
        * Time Complexity  = O(n); n = number of gas stations OR size of cost array
        * Space Complexity = O(1)
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if the solution doesn't exist, then gas.sum() < cost.sum() to complete the loop 
        // MEANING you CANT complete the loop
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int gasLeft = 0; 
        int result = 0; // starting position that we will return; GREEDY since we're starting at the first index AKA index 0

        for (int i = 0; i < gas.length; i++) {
            gasLeft += (gas[i] - cost[i]);  // update the total gas left

            // if gasLeft < 0, this position/index doesn't work
            // MEANING we CANT reach the next station
            if (gasLeft < 0) {
                gasLeft = 0;    // since it doesn't work, RESET IT 
                result = i + 1; // starting position set to the NEXT one
            }
        }

        return result;
    }
}

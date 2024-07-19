class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] finalOutput = new int[N];

        /*
            Input: nums = [1, 2, 3, 4]
            N = 4

            finalOutput[0] = 1

            Iteration 1:
                finalOutput[1] = finalOutput[0] * nums[0] -> finalOutput[1] = 1 * 1 -> 1

            Iteration 2:
                finalOutput[2] = finalOutput[1] * nums[1] -> finalOutput[2] = 1 * 2 -> 2

            Iteration 3:
                finalOutput[3] = finalOutput[2] * nums[2] -> finalOutput[3] = 2 * 3 -> 6

            finalOutput = [1, 1, 2, 6]
         */
        finalOutput[0] = 1;
        for(int i = 1; i < N; i++) {
            finalOutput[i] = finalOutput[i - 1] * nums[i - 1];
        }

        /*
            Input: nums = [1, 2, 3, 4]
            N = 4

            finalOutput = [1, 1, 2, 6]
            rightProduct = 1

            Iteration 1:
                finalOutput[3] = finalOutput[3] * rightProduct -> finalOutput[3] = 6 * 1 -> 6
                rightProduct = 1 * 4 -> 4

            Iteration 2:
                finalOutput[2] = finalOutput[2] * rightProduct -> finalOutput[2] = 2 * 4 -> 8
                rightProduct = 4 * 3 -> 12

            Iteration 3:
                finalOutput[1] = finalOutput[1] * rightProduct -> finalOutput[1] = 1 * 12 -> 12
                rightProduct = 12 * 2 = 24

            Iteration 4:
                finalOutput[0] = finalOutput[0] * rightProduct -> finalOutput[0] = 1 * 24 -> 24
                rightProduct = 24 * 1 = 24

            finalOutput = [24, 12, 8, 6]
         */
        int rightProduct = 1;
        for(int i = N - 1; i >= 0; i--) {
            finalOutput[i] = finalOutput[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return finalOutput;
    }
}
class Solution {
    /*
        MONOTONIC DECREASING STACK
        time complexity  = O(n)
        space complexity = O(n)

        * only pop from stack if you find a bigger number from temperatures[] than stack.peek() AKA top of the stack
            * then add the bigger number from tempratures[] to the stack
        * add to the stack if number from tempratures[] is smaller than stack.peek()

    */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }

            stack.push(currDay);
        }

        return answer;
    }
}
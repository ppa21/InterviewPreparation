class Solution {
    /*
     * time complexity  = O(nlogn)
     * space complexity = O(n)

     * when cars "crash", they become ONE. hence, CAR FLEET
     * 3 cars crash ---> 1 car fleet
     * take the speed of the SLOWEST car
     * how do we know if 2 cars will crash?
     * 2 cars
     * car a reaches destination in 3 secs
     * car b reaches destination in 2.5 secs
     * only one lane
     * car a is ahead of car b
     * CRASH
     * 1 car fleet
     * if car b reaches destination before (2.5s) or at the same time as car a (3s)
     * THEY BECOME A CAR FLEET
     * take the speed of CAR A
     * formula = (destination position - current position) / current speed
     */
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }

        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, (a, b) -> a[0] - b[0]);

        for (int i = position.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }

        return stack.size();
    }
}
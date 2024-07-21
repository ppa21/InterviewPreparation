class Solution {
    /*
        * Time Complexity  = O(logn); n = time it takes to determine if a number is happy grows logarithmically with the size of the number 'n'
        * Space Complexity = O(logn)
    */ 
    public boolean isHappy(int n) {
        // If the number is 1 or -1, it's a happy number
        if (n == 1 || n == -1) {
            return true;
        }

        Set<Integer> visited = new HashSet<Integer>(); // Create a set to store the numbers

        // Compute square until getting duplicate value
        while (!visited.contains(n)) { // While the number is not already in the set. For n=19, it's not in the set, so we enter the loop.
            visited.add(n); // Add the number to the set. For n=19, we add 19 to the set.
            // Using helper function to compute the sum of squares
            n = sumOfSquare(n); // For n=19, we get 82 (square of 1 plus square of 9).

            // If the sum is 1, it's a happy number
            if (n == 1) {
                return true; // But for n=82, it's not 1, so we skip this.
            }
        }

        // If we've seen this number before, it's not a happy number
        return false; // But for n=19, we never reach this line because 19 is a happy number.
    }

    public int sumOfSquare(int n) {
        int output = 0; // Initialize the sum to 0

        // Compute the sum of squares of the digits
        while (n != 0) { // While the number is greater than 0. For n=19, it's greater than 0, so we enter the loop.
            int digit = n % 10; // Get the last digit of the number. For n=19, the last digit is 9.
            digit = digit * digit; // Square the digit. For digit=9, we get 81.
            output += digit; // Add the square of the digit to the sum. For output=0 and digit=81, we get output=81.
            n = n / 10; // Remove the last digit from the number. For n=19, we get 1.
        }

        // Return the sum of squares of the digits
        return output; // For n=19, we return 82 (square of 1 plus square of 9).
    }
}

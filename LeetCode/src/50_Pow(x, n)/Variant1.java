/*
        * time complexity  = O(logn)
        * space complexity = O(1)

        * Variant: What if you had to solve the problem in SC O(1)?
          Retain the TC of O(LOG N).
*/
class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
    
    public double binaryExp(double x, long n) {
        // handle negative exponents: x^(-n) = (1/x)^n
        if (n < 0) {
            x = 1.0 / x;
            n = Math.abs(n);
        }
        
        double result = 1.0;       // Accumulates final answer
        double base = x;           // Tracks powers: x^1, x^2, x^4, x^8...
        
        // binary exponentiation; number can be expressed as a sum of powers of 2
        // example: 13 = 8+4+1 = 1101₂, so x^13 = x^8 × x^4 × x^1
        while (n > 0) { // n != 0
            if (n % 2 == 1) {      // if rightmost bit is 1
                result *= base;    // multiply that power into result
            }
            base *= base;          // square base for next power of 2
            n /= 2;                // shift right (remove processed bit)
        }
        
        return result;
    }
}

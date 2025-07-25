/*
        * time complexity  = O(logn)
        * space complexity = O(logn)
*/
class Solution {
    public double myPow(double x, int n) {
        return myPow(x, (long) n);  // Convert to long to handle overflow
    }
    
    public double myPow(double x, long n) {
        // Handle negative exponents: x^(-n) = 1 / x^n
        if (n < 0) {
            return 1.0 / myPow(x, Math.abs(n));
        }
        
        // Base case: x^0 = 1
        if (n == 0) {
            return 1;
        }
        
        // Divide-and-conquer: calculate x^(n/2) once
        double half = myPow(x, n / 2);
        
        // Key insight: x^n = (x^(n/2))^2 when n is even
        //              x^n = x × (x^(n/2))^2 when n is odd
        if (n % 2 == 1) {
            return x * half * half;    // Odd: need extra x factor
        } else {
            return half * half;        // Even: just square the half
        }
    }
}

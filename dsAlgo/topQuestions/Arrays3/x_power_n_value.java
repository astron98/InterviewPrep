class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        int neg = 1;
        /*
        here, -INT_MIN is +2147483648 which is > INT_MAX, so it'll give Integer overflow. So just give -ve to n/2 values using "neg" variable.
        */
        if(n<0) {
            x = 1/x;
            neg = -1;
        }
        
        return (n%2==0)? myPow(x*x, neg*(n/2)) : x * myPow(x*x, neg*(n/2));
    }
}

//leetcode: 50
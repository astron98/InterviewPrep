class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend== (1<<31) && divisor==-1)
            return Integer.MAX_VALUE;
        
        boolean sign = (dividend>=0) == (divisor>=0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int res = 0;
        while(dividend - divisor >=0) {
            int count = 0;
            while(dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            // System.out.print((count) +" ");  //debug
            res += 1 << count;  //add the power of 2 for count.
            dividend -= divisor << count;  //reduce the dividend by divisor * power of 2 found 
        }
        
        return (!sign)? res*-1 : res;   //return with correct sign
    }
}
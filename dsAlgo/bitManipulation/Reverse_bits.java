// leetcode 190. Reverse Bits

public int reverseBits(int a) {
    int res = 0;
    
    //method 1
    // while(a!=0) {
    //     double prsbm = (Math.log(a & -a) / Math.log(2)) + 1;
    //     res |= (1<< (Integer.SIZE - (int)prsbm));
    //     a &= (a-1);
    // }
    
    // //method 2
    for(int i=31;i>=0;i--) {
        int mask = 1 << (31-i); //create a mask for current bit from lsb
        if((a & mask) != 0) {   //check if that bit is set
            res |= (1 << i);    //if 1 then set that bit in result = res
        }
    }

    // System.out.println(Integer.toBinaryString(res));
    return res;
}

/*
testcases:

Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
*/
/*
Solution:
The truth table of XOR clearly depicts that for same operands 
it returns 0 and for different operands it returns 1. 
So as 1 ^ 1 = 0 and 0 ^ 0 = 0 then 5 ^ 5 = 0101 ^ 0101 = 0000. 
One more thing to keep in mind is that XOR operator is 
cumulative in nature i.e., say 5 ^ 3 ^ 5 is same as 5 ^ 5 ^ 3.

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 

Sample Input
5
23 27 23 17 17

Sample Output
27
*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    //write your code here
    int res = 0;
    for(int val : arr) {
        res ^= val;
    }
    
    System.out.println(res);
  }

}
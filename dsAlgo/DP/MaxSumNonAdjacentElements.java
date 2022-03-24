/*
MaxSumNonAdjacentElements

Constraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000

Sample Input
6
5
10
10
100
5
6

Sample Output
116
*/

import java.io.*;
import java.util.*;

public class MaxSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        
        int exc = 0;
        int inc = arr[0];
        for(int i=1;i<n;i++) {
            int currExc = Math.max(exc, inc);
            int currInc = exc + arr[i];
            
            exc = currExc;
            inc = currInc;
        }
        
        System.out.println(Math.max(exc, inc));
    }
}
import java.io.*;
import java.util.*;

/*
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2

Sample Input
6
9
6
7
6
3
8
1

Sample Output
5
*/

public class bsStock_k_transactions {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        int k = sc.nextInt();
        
        bsStock_k_transactions(n, arr, k);
    }
    
    private static void bsStock_k_transactions(int n, int[] arr, int k) {
        int[][] dp = new int[k+1][n];
        
        // // method 1: O(N^3) algo.

        // for(int t=1;t<=k;t++) {
        //     for(int d=1;d<n;d++) {
        //         int max = dp[t][d-1];
        //         // dp[t][d] = dp[t][d-1];
        //         for(int pd=d-1;pd>=0;pd--) {
        //             int ptilm1 = dp[t-1][pd];
        //             int ptth = arr[d] - arr[pd];
        //             max = Math.max(max, ptilm1 + ptth);
        //         }
                
        //         dp[t][d] = max;
        //     }
        // }
        
        //method 2: N^2 algo. (most efficient)
        /*
        formula: arr[d] - arr[d-i] + dp[t-1][d-1]
        rearrange: (dp[t-1][d-1] - arr[d-i]) + arr[d]
        */
        for(int t=1;t<=k;t++) {
            int max = Integer.MIN_VALUE;
            for(int d=1;d<n;d++) {
                // int max = dp[t][d-1];
                max = Math.max(max, dp[t-1][d-1] - arr[d-1]);
                dp[t][d] = Math.max(max+arr[d], dp[t][d-1]);
            }
        }
        
        System.out.println(dp[k][n-1]);
    }

}
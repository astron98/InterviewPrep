import java.io.*;
import java.util.*;

/*
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10

Sample Input
9
11
6
7
19
4
1
6
18
4

Sample Output
30
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
            
        bsStocks_twoTransactionsAllowed(n, arr);
    }
    
    private static void bsStocks_twoTransactionsAllowed(int n, int[] arr) {
        int mpist = 0;  //max. profit if sold today
        int leastsf = arr[0]; //least buying price so far
        int[] dp_mpist = new int[n]; //highest mpist till date
        for(int i=1;i<arr.length;i++) {
            leastsf = Math.min(leastsf, arr[i]);
            mpist = arr[i] - leastsf;
            
            dp_mpist[i] = Math.max(mpist, dp_mpist[i-1]);
        }
        
        int mpibt = 0;  //max. profit if bought today
        int maxat = arr[n-1]; //max. selling price so far
        int[] dp_mpibt = new int[n]; //highest mpibt till date
        int result = 0;
        for(int i=n-2;i>=0;i--) {
            maxat = Math.max(maxat, arr[i]);
            mpibt = maxat - arr[i];
            
            dp_mpibt[i] = Math.max(mpibt, dp_mpibt[i+1]);
            
            //highest non-overlapping transaction values on same day will be the result
            result = Math.max(result, dp_mpist[i]+dp_mpibt[i]);
        }
        
        System.out.println(result);
    }

}
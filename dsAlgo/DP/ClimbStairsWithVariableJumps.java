import java.io.*;
import java.util.*;

/*
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20

Sample Input
10
3
3
0
2
1
2
4
2
0
0

Sample Output
5

*/

public class Main {
    //memoization
    public static int climbStairsVariableJumps(int n, int[] t, int[] arr) {
        if(n>arr.length)
            return 0;
            
        if(n==arr.length)
            return 1;
            
        if(t[n] !=-1)
            return t[n];
        int count = 0;
        for(int i=1;i<=arr[n];i++) {
            count += climbStairsVariableJumps(n+i, t, arr);
        }
        
        t[n] = count;
        
        return t[n];
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        int[] t = new int[n+1];
        Arrays.fill(t, -1);
        // int res = climbStairsVariableJumps(0, t, arr);
        // System.out.println(res);
        
        
        //tabulation
        Arrays.fill(t, 0);
        t[n] = 1;
        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=arr[i] && i+j<=n; j++) {
                t[i] += t[i+j];
            }
        }
        
        System.out.println(t[0]);
    }

}
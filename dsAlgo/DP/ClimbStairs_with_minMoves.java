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
4
*/

public class Main {
    public static final int mx = Integer.MAX_VALUE;
    
    // Memoization
    // public static int csMinMoves(int n, int count, int[] t, int[] arr) {
    //     if(t[n]!=mx)
    //         return t[n];
            
    //     if(n == arr.length)
    //         return count;
    //     int res = Integer.MAX_VALUE;
    //     for(int i=1;i<=arr[n];i++){
    //         if(n+i<=arr.length)
    //             res = Math.min(res, csMinMoves(n+i, count+1, t, arr));
    //     }
        
    //     if(res!=mx){
    //         t[n] = res+1;
    //     }
        
    //     return t[n];
    // }
    
    
    // //tabulation
    public static int csMinMoves(int n, int count, int[] t, int[] arr) {
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i]==0) {
                continue;
            }
            int res = mx;
            for(int j=1;j<=arr[i];j++) {
                if(i+j<=arr.length)
                    res = Math.min(res, t[i+j]);
            }
            
            if(res!=mx){
                t[i] = res+1;
            }
        }
        
        return t[0];
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] t = new int[n+1];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[n] = 0;
        int res = csMinMoves(0, 0, t, arr);
        System.out.println(t[0]);
    }

}
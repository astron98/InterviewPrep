import java.io.*;
import java.util.*;

/*
Constraints
0 <= n <= 20

Sample Input
4

Sample Output
7
*/

public class Main {
    //memoization
    public static int climbStairs(int n, int[] t) {
        if(n<=0) {
            if(n==0)
                return 1;
            return 0;
        }    
            
        if(t[n] !=-1)
            return t[n];
        for(int i=1;i<=3;i++) {
            if(t[n]==-1)
                t[n] = climbStairs(n-i, t);
            else
                t[n] += climbStairs(n-i, t);
        }
        
        return t[n];
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n+1];
        // for(int i=0;i<n;i++)    
        Arrays.fill(t, -1);
        // System.out.println(climbStairs(n, t));
        
        //tabulation
        t[0] = 1;
        for(int i=1;i<=n;i++) {
            for(int j=1; j<=3; j++) {
                if(i-j>=0) {
                    if(t[i]==-1)
                        t[i] = t[i-j];
                    else 
                        t[i] += t[i-j];
                }
            }
        }
        
        System.out.println(t[n]);
    }

}
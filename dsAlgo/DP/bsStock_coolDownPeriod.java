import java.io.*;
import java.util.*;

/*

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10

Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25

Sample Output
19
*/
public class Main {

    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        bsStock_coolDownPeriod(n, arr);
    }
    
    private static void bsStock_coolDownPeriod(int n, int[] arr) {
        int bsp = -arr[0];    //buy state price (values in negative)
        int ssp = 0;    //sell state price (values in positive)
        int csp = 0;    //coolDown state price
        
        for(int i=1; i<n; i++) {
            int currBuy = Math.max(bsp, csp - arr[i]);
            int currSell = Math.max(ssp, arr[i] + bsp); //bcoz bsp could be negative value during loan/debt
            int currCsp = Math.max(csp, ssp);
            
            bsp = currBuy;
            ssp = currSell;
            csp = currCsp;
        }
        
        //ssp is answer, because ssp will contain the latest profit after selling the previous bsp on today's price,
        //but at the same time csp will just contain highest profit from (prev csp vs curr ssp) i.e. max(csp, ssp)
        //so, ssp will contain the net profit which csp wont as its a cool-down for csp at that day. (last day)
        System.out.println(ssp);
    }

}
import java.io.*;
import java.util.*;

/*
You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5

Input Format
A number n
.. n more elements
A number fee

Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.


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
3

Sample Output
13
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        int fee = sc.nextInt();
        
        bsStock_transactionFee(n, arr, fee);
    }
    
    private static void bsStock_transactionFee(int n, int[] arr, int fee) {
        int bsp = -arr[0];    //buy state price (values in negative)
        int ssp = 0;    //sell state price (values in positive)
        
        for(int i=1; i<n; i++) {
            int currBuy = Math.max(bsp, ssp - arr[i]);
            int currSell = Math.max(ssp, arr[i] + bsp - fee); //bcoz bsp could be negative value during loan/debt
            bsp = currBuy;
            ssp = currSell;
        }
        
        System.out.println(Math.max(bsp, ssp));
    }

}
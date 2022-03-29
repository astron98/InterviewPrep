import java.io.*;
import java.util.*;

/*
 You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

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

/*
Solution:
- its a greedy approach problem, so just take the stock price array, 
buy at an increase in price after dip & sell at a dip right after increase in price.

- do step 1 for all the non-overlapping buy-sells & add all the profits to get the max. profit.

O(N) time
O(1) space
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        int buy = -1;
        int profit = 0;
        
        for(int i=0;i<n-1;i++) {
            int curr = arr[i];
            int next = arr[i+1];
            
            if(curr<next && buy==-1) {
                buy = arr[i];
            }
            else if(curr> next && buy!=-1) {
                profit += curr-buy;
                buy=-1;
            }
        }
        
        if(buy!=-1 && arr[n-1]>buy)
            profit += arr[n-1] - buy;
        
        System.out.println(profit);
    }

}
import java.io.*;
import java.util.*;

/*
explanation: https://www.algorithmsandme.com/sort-a-k-sorted-array/

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n

Sample Input
9
3
2
4
1
6
5
7
9
8
3

Sample Output
1
2
3
4
5
6
7
8
9

*/

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int i=0;
      for(i=0;i<=k;i++)
        pq.add(arr[i]);
        
        for(;i<n;i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty())
            System.out.println(pq.remove());
   }

}
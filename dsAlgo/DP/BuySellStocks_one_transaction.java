import java.io.*;
import java.util.*;

/*
Question: You are required to print the maximum profit you can make if you
are allowed a single transaction.

Solution: (greedy approach)
time: O(N), space: O(N)

- initialize a stack
- add 1st element
- for subsequent elements check if the top element on stack > currElement,
  if yes the pop() all until this condition holds true.
- for top element < curr Element, pop until there is just 1 element or 
  until this condition holds true.
- for top element < currElement
    check the difference & compare with profit val if > profit,
    then update the profit to curr diff.
- lastly push the element to the stack.

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
17
*/

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
            
        // bsStocks_oneTransaction();
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int price : arr) {
            if(st.size()==0)
                st.push(price);
            while(st.size()>0 && st.peek()>price)
                st.pop();
            while(st.size()>1 && st.peek() < price)
                st.pop();
            if(st.size()>0 && st.peek()<price)
                res = Math.max(res, price - st.peek());
            st.push(price);
        }
        
        System.out.println(res);
    }

}
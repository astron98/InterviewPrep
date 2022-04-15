import java.io.*;
import java.util.*;

/*
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 

Sample Input
7
1 
3 
4 
5 
1 
6 
2

Sample Output
Missing Number -> 7
Repeating Number -> 1

*/

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
    //write your code here
    int xor = 0;
    /*
    take xor of [1, n], [arr0,...,arrN]
    by this we would get the missing val,
    one repeating value.
    */
    for(int i=0;i<arr.length;i++) {
        xor ^= arr[i];
        xor ^= i+1; //from 1 to n
    }
    
    //take rsb & seperate 2 different kinds of val with rsb as either 0 or 1
    int rsb = xor & -xor;
    int x = 0, y = 0;
    for(int val : arr) {
        if((val & rsb) == 0) 
            x ^= val;
        else
            y ^= val;
    }
    
    for(int i=1;i<=arr.length; i++) {
        if((i & rsb) == 0) 
            x ^= i;
        else
            y ^= i;
    }
    
    //we got both the missing, repeating val seperated.
    //swap the x,y if y is the repeating number instead of x.
    for(int val : arr) {
        if(x==val) {
            int t = x;
            x = y;
            y = t;
            break;
        }
    }
            
    
    System.out.println("Missing Number -> "+ x);
    System.out.println("Repeating Number -> "+ y);
  }

}
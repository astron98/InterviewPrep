import java.io.*;
import java.util.*;

/*
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 

Sample Input
6
23 27 23 17 17 37

Sample Output
27
37
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
    int xory = 0;
    for(int val : arr)
        xory ^= val;
    int rsbm = xory & -xory;
    
    /*
    - use rsbm to seperate 2 types of numebers whose rsbm bit is different i.e. one type has 1, other type has 0 as rsbm bit. 
    - so after this, we got 2 different arrays with only one element which is unique then xoring that array will get the resultant value.
    */
    int a = 0, b=0;
    for(int val : arr) {
        if((val&rsbm) == 0)
            a ^= val;
        else
            b ^= val;
    }
    if(a<b)
        System.out.println(a + "\n" + b);
    else
        System.out.println(b + "\n" + a);
  }

}
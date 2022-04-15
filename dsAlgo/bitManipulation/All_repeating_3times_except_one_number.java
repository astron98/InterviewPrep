import java.io.*;
import java.util.*;

/*
 All numbers occur thrice in the array except one.

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9

Sample Input
4
1 1 1 2 

Sample Output
2
*/

public class {

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
    int tn = Integer.MAX_VALUE, //3N (all bits=1 initially)
        tnp1=0, //3N+1 
        tnp2=0; //3N+2
    for(int i=0;i<arr.length;i++) {
        int cwtn = arr[i] & tn;//common btw arr[i], tn(3N)
        int cwtnp1 = arr[i] & tnp1;//common btw arr[i], tn+1
        int cwtnp2 = arr[i] & tnp2;//common btw arr[i], tn+2
        
        tn = tn & (~cwtn);  //off the 1s in tn
        tnp1 = tnp1 | cwtn;//on the 1s from cwtn in tnp1 & put the remaining previous bits as it is.
        
        tnp1 = tnp1 & (~cwtnp1);
        tnp2 = tnp2 | cwtnp1;
        
        tnp2 &= (~cwtnp2);
        tn |= cwtnp2;
    }
    /*
    Result: since, n-1 elements are there 3 times & only one element is unique, we'll get the result in the (3*n+1) as it will have the one extra bit except for the multiples which will be the unique element itself.
    */
    System.out.println(tnp1); 
  }

}
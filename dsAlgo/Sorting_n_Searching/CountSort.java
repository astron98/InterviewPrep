import java.io.*;
import java.util.*;

/*
Count sort is stable sort.

time: O(N)
space: O(N) + O(range of elements in arr) = O(N)

Constraints
1 <= N <= 10000
-10^8 <= arr[i] <= 10^8

Sample Input
5
7 
-2 
4 
1 
3

Sample Output
-2
1
3
4
7
*/

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int[] farr = new int[max-min+1];
    //1. create & fill the frequency arr
    for(int val : arr) {
        farr[val-min]++;
    }
    
    //2. create a prefix sum
    for(int i=1;i<farr.length;i++) {
        farr[i] += farr[i-1];
    }
    
    int[] res = new int[arr.length];
    for(int i=arr.length-1; i>=0; i--) {
        int val = arr[i];
        int position = farr[val - min];
        int idx = position - 1;
        res[idx] = val;
        farr[val - min]--;
    }
    
    for(int i=0;i<res.length;i++)
        arr[i] = res[i];
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
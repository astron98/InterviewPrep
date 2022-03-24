import java.io.*;
import java.util.*;

/*
Sample Input
5
7 
2 
4 
1 
3

Sample Output
After sorting on 1 place -> 1 2 3 4 7 
1 2 3 4 7 
*/

public class Main {

  public static void radixSort(int[] arr) {
    // write code here
    int max = Integer.MIN_VALUE;
    for(int val:arr) {
        if(val > max)
            max=val;
    }
    
    int exp = 1;
    while(exp<= max) {
        countSort(arr, exp);
        exp *= 10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    System.out.print("After sorting on " + exp + " place -> ");
    
    int[] farr = new int[10];
    //1. create & fill the frequency arr
    for(int val : arr) {
        farr[val/exp % 10]++;
    }
    
    //2. create a prefix sum
    for(int i=1;i<farr.length;i++) {
        farr[i] += farr[i-1];
    }
    
    int[] res = new int[arr.length];
    for(int i=arr.length-1; i>=0; i--) {
        int val = arr[i];
        int position = farr[val/exp % 10];
        int idx = position - 1;
        res[idx] = val;
        farr[val/exp % 10]--;
    }
    
    for(int i=0;i<res.length;i++)
        arr[i] = res[i];
    
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
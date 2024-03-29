import java.io.*;
import java.util.*;

//we use Radix sort here to sort the dates.
/*
concept learnt:
- Integer.parseInt(arr[i],10); to convert string to base-10 numeral we use 10 in parseInt()
*/
public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    countSort(arr, 1000000, 100, 32); //sort by dates
    countSort(arr, 10000, 100, 13); //sort by months
    countSort(arr, 1, 10000, 2501); //sort by years
    
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    String[] ans = new String[arr.length];
    
    //freq arr
    int[] farr = new int[range];
    for(int i=0;i<arr.length; i++) {
        farr[Integer.parseInt(arr[i],10) /div % mod]++;
    }
        
    for(int i=1;i<farr.length;i++)
        farr[i] += farr[i-1];
        
    //stable sort
    for(int i=arr.length-1;i>=0;i--) {
        int val = Integer.parseInt(arr[i], 10);
        int pos = farr[val / div%mod] - 1;
        ans[pos] = arr[i];
        farr[val/div%mod]--;
    }
    
    for(int i=0;i<ans.length;i++)
        arr[i] = ans[i];
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
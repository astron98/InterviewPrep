import java.io.*;
import java.util.*;

/*
Bubble sort:
- after every inner loop iteration, (n-i)th will be at its correct position (i.e. it will be sorted)
- thus the inner loop runs only till (n-i)th element in array.
    - for(int j=0; j<arr.length-i; j++)
- Always compare arr[j] with arr[j+1] element to get the correct comparison
- the outer loop will only run for (N-1) elements becoz last element will automatically get sorted in an array of N elements.
*/

public class Main {

  public static void bubbleSort(int[] arr) {
    //write your code here
    for(int i=1;i<=arr.length;i++) {
        for(int j=0; j<arr.length-i; j++) {
            if(isSmaller(arr, j+1, j)) {
                swap(arr, j+1, j);
            }
        }
    } 
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    bubbleSort(arr);
    print(arr);
  }

}
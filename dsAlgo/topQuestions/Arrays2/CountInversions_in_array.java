import java.util.*;
import java.io.*;

class CountInversions_in_array
{
  public static int merge(int[] arr, int low, int mid, int high) {
    int[] temp = new int[arr.length];
    int i=low, 
        j=mid, 
        k=low, 
        inversePairCount=0;
    while(i<mid && j<=high) {
      if(arr[i] <= arr[j])
        temp[k++] = arr[i++];
      else {
        temp[k++] = arr[j++];
        /* 
        In the left array, from ith element till mid everything will be greater than the jth element. 
        In the case when the ith element itself is greater than the jth element.
        Thus adding (mid-i) to the count.
        */
        inversePairCount += mid - i;   
      }
    }

    while(i<mid) 
      temp[k++] = arr[i++];

    while(j <= high)
      temp[k++] = arr[j++];

    for(i=low; i<=high; i++) {
      arr[i] = temp[i];
    }

    return inversePairCount;
  }

  public static int mergeSort(int[] arr, int low, int high) {
    int count = 0, mid = 0;
    if(low < high) {
      mid = (low + high) / 2;
      count += mergeSort(arr, low, mid);
      count += mergeSort(arr, mid + 1, high);
      count += merge(arr, low, mid+1, high);
    }

    return count;
  }

  public static void main (String[] args) throws java.lang.Exception
  {
    File input = new File("./input.txt");
    Scanner sc = new Scanner(input);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++)
      arr[i] = sc.nextInt();
    int totalInversePairs = mergeSort(arr, 0, n-1);
    System.out.println("total inversion pairs: " + totalInversePairs);  
    sc.close();
  } 
}

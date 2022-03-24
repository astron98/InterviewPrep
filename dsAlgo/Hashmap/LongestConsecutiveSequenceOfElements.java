import java.io.*;
import java.util.*;

/*
Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15

Sample Input
17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11

Sample Output
5
6
7
8
9
10
11
12
13

*/

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] arr = new int[n];
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i=0;i<n;i++) {
        arr[i] = sc.nextInt();
        hm.put(arr[i], true);   //store all the values in a hashmap
    }
    
    for(Integer k : hm.keySet()) {
        /*
        if Key-1 is present then key isn't the first element in the sequence of elements present in hashmap
        So put value of Key as false, denoting its not the 1st element in the sequence
        */
        if(hm.containsKey(k-1)) 
            hm.put(k, false);
    }
    
    int start = 0, size = -1;
    for(Integer k : hm.keySet()) {
        //on process the element which is 1st in the sequence
        if(hm.get(k)==false) continue;
        int i=k+1, j=1;

        //calculate the length of the sequence present in the HM starting with that 1st element.
        while(hm.containsKey(i)) {
            i++;
            j++;
        }
        
        //if its the longest sequence then note it down.
        if(j>size) {
            start = k;
            size = j;
        }
    }
    
    //print the longest sequence
    for(int i=start;i<start+size;i++) {
        System.out.println(i);
    }
 }

}
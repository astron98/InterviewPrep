import java.io.*;
import java.util.*;

/*
Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.

_____________
Sample Input
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Sample Output
10
10
10
20
20
30
30
40
40
50
*/

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
    
    public void upHeapify(int i) {
        if(i==0)
            return;
        
        int parent = (i-1)/2;
        if(data.get(parent) > data.get(i)) {
            swap(i, parent);
            upHeapify(parent);
        }
    }
    
    public void downHeapify(int i) {
        int lci = (2*i+1)/2;
        int rci = (2*i+2)/2;
        int n = data.size();
        
        int swapIdx = i;
        if(lci<n && data.get(lci)<data.get(i))
            swapIdx = lci;
        if(rci < n && data.get(rci)<data.get(swapIdx))
            swapIdx = rci;
            
        if(swapIdx!= i) {
            swap(i, swapIdx);
            downHeapify(swapIdx);
        }
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upHeapify(data.size()-1);
      
    }

    public int remove() {
      // write your code here
      if(data.size()==0) {
          System.out.println("Underflow");
          return -1;
      }
      
      int res = data.get(0);
      swap(0, data.size()-1);
      data.remove(data.size()-1);
      downHeapify(0);
      return res;
    }

    public int peek() {
      // write your code here
      if(data.size()==0) {
          System.out.println("Underflow");
          return -1;
      }
      
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
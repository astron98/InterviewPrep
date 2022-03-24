import java.io.*;
import java.util.*;
/*
Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
8

Sample Output
10

Solution:
1. sort the array & return kth largest O(N*logN), space: O(N) for an extra array
2. Best - use min heap time: O(N*logK), space: O(k) - logK to add to min-heap everytime we traverse a node in N-ary tree.
3. use quick randomized sort O(N^2), space: O(N), to store the tree elements in an array. can do the sort 
directly on the tree though.
*/

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }
  
  public static int size(Node node) {
      if(node == null) return 0;
      int count = 1;
      for(Node child : node.children) {
          count += size(child);
      }
      
      return count;
  }
    
  public static int kthLargest(Node node, int k){
    // write your code here
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    kthLargestUtil(node, k, pq);
    return (pq.size()>0)? pq.peek() : -1;
  }
  
  //time: O(N*logK) - logK to add to min-heap everytime we traverse a node in N-ary tree.
  public static void kthLargestUtil(Node node, int k, PriorityQueue<Integer> pq){
    if(node==null) return;
    if(pq.size()<k)
        pq.add(node.data);
    else if(node.data > pq.peek()) {  //when pq.size()>=k && node.data > pq.peek()
        pq.remove();
        pq.add(node.data);
    }
    
    for(Node child : node.children) {
        kthLargestUtil(child, k, pq);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int kthLargest = kthLargest(root, k);
    System.out.println(kthLargest);
  }

}
import java.io.*;
import java.util.*;


/*
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
4

 THe diameter is defined as maximum number of edges between any two nodes in the tree.

 time: O(N)
 space: O(1)
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
  
  public static int dia = Integer.MIN_VALUE;
  public static int diameter(Node node) {
      if(node == null ) return 0;
      
      int h1 = -1, h2 = h1;
      for(Node child : node.children) {
          int ch = diameter(child);
          if(ch>h1) {
            h2 = h1;
            h1 = ch;
          }
          else if(ch>h2)
            h2 = ch;
            
        dia = Math.max(dia, 2 + h1 + h2);
      }
      
      return 1 + h1;
  }

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    diameter(root);
    System.out.println(dia);
  }

}
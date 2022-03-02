import java.io.*;
import java.util.*;

/*
1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. 
The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.

Sample Input:
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2

output:
12
50
*/

public class PrintNodesKDistanceAway {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static ArrayList<Node> findNode(Node root, int data) {
    if(root == null) return null;
    ArrayList<Node> curr =  new ArrayList<>();
    if(root.data==data) return new ArrayList<>(Arrays.asList(root));
    ArrayList<Node> left = findNode(root.left, data);
    ArrayList<Node> right = findNode(root.right, data);
    if(left!=null && left.size()>0)
        curr.addAll(left);
        
    if(right!=null && right.size()>0)
        curr.addAll(right);
    if(curr.size()>0)
        curr.add(root);
    return curr;
  }
  
    public static void printKLevelsDown(Node root, int k, Node blocker) {
        if(root==null || k<0 || root==blocker) return;
        if(k==0) {
            System.out.println(root.data);
            return;
        }
        printKLevelsDown(root.left, k-1, blocker);
        printKLevelsDown(root.right, k-1, blocker);
    }
    
  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    //1. find the node 
    //2. print all the nodes at K level down from that node.
    ArrayList<Node> path = findNode(node, data);
    for(int i=0;i<path.size();i++) {
        Node blocker = (i==0)? null : path.get(i-1);
        printKLevelsDown(path.get(i), k-i, blocker);
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("../input"));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}
import java.io.*;
import java.util.*;

/*
You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order.

Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100

Sample Output
25 75
30 70
*/

public class Main {
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
  
  private static Node inorder(Stack<Pair> stack) {
	    while (stack.size() > 0) {
	        Pair top = stack.peek();
	        if (top.state == 1) {
	            if (top.node.left != null) {
	                stack.push(new Pair(top.node.left, 1));
	            }
	            top.state++;
	        } else if (top.state == 2) {
	            if (top.node.right != null) {
	                stack.push(new Pair(top.node.right, 1));
	            }
	            top.state++;
	            return top.node;
	        } else {
	            stack.pop();
	        }
	    }
	    return null;
	}
        
	private static Node revInorder(Stack<Pair> stack) {
	    while (stack.size() > 0) {
	        Pair top = stack.peek();
	        if (top.state == 1) {
	            if (top.node.right != null) {
	                stack.push(new Pair(top.node.right, 1));
	            }
	            top.state++;
	        } else if (top.state == 2) {
	            if (top.node.left != null) {
	                stack.push(new Pair(top.node.left, 1));
	            }
	            top.state++;
	            return top.node;
	        } else {
	            stack.pop();
	        }
	    }
	    return null;
	}
    
    /*
		Description: Target sum pair in BST
    */
    private static void tspUtil(Node root, int target) {
        Stack<Pair> startStack = new Stack<>();
        Stack<Pair> endStack = new Stack<>();
        startStack.push(new Pair(root, 1));
        endStack.push(new Pair(root, 1));

        Node startNode = inorder(startStack);
        Node endNode = revInorder(endStack);

        while (startNode.data < endNode.data) {
            if (startNode.data + endNode.data == target) {
                System.out.println(startNode.data + " " + endNode.data);
                startNode = inorder(startStack);
                endNode = revInorder(endStack);
            } else if (startNode.data + endNode.data < target) {
                startNode = inorder(startStack);
            } else {
                endNode = revInorder(endStack);
            }
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    Node root = construct(arr);
    // write your code here
    tspUtil(root, data);
  }

}
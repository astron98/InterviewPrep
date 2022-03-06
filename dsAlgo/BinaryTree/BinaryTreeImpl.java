import java.io.*;
import java.util.*;

public class BinaryTreeImpl {
	static class Node {
		int val;
		Node left;
		Node right;
		Node() {}
		Node(int val) {
			this.val = val;
		}
		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class Pair {
		Node node;
		int state;
		Pair(){}
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
		int idx=0;
		
		while(st.size()>0) {
			Pair top = st.peek();
			if(top.state == 1) {
				//left node
				idx++;
				if(arr[idx]!=null) {
					top.node.left = new Node(arr[idx]);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				}
				top.state++;
			}
			else if(top.state == 2) {
				//right node
				idx++;
				if(arr[idx]!=null) {
					top.node.right = new Node(arr[idx]);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				}
				top.state++;
			}
			else {
				st.pop();
			}
		}

		return root;
	}


	//display is done in preorder manner
	public static void display(Node node) {
		//preorder
		if(node==null) return;
		String str = "";
		str += node.left == null? "." : node.left.val + "";
		str+= " <- "+node.val+ " -> ";
		str += node.right == null? "." : node.right.val + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) throws Exception {
		//BT is build during Euler path.
		//50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
		Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75,62,null,70, null, null, 87, null, null};
		Node root = construct(arr);
		display(root);
	}
}

import java.util.*;
import java.io.*;

public class GenericTreeImpl {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		Node(){}
		Node(int data) {
			this.data = data;
		}
	}

	public static Node construct(int[] arr) {
		Stack<Node> st = new Stack<>();

		Node root=null;

		for(int i=0; i<arr.length; i++) {
			/*
			pop the node when we get a -1. i.e. we are in the postOrder of the euler path & 
			all the children nodes of this node are already traversed.
			*/
			if(arr[i]== -1)	
				st.pop();
			else {
				Node t = new Node(arr[i]);
				if(st.size()>0) {
					st.peek().children.add(t);	//add curr node as the children of the top node in the stack
				}
				else
					root = t;
				st.push(t);	//push the node to the stack after the above step.
			}
		}

		return root;
	}

	public static void display(Node root) {
		StringBuilder sb = new StringBuilder(root.data+"-> ");
		for(Node child : root.children) {
			sb.append(child.data+", ");
		}

		sb.append(".");

		System.out.println(sb.toString());	//print all children of curr node at this level.

		for(Node child : root.children) {
			display(child);	//do a recursive call to the child node.
		}

	}

	public static void main(String[] args) {
		Node root;

		int[] arr = {10, 20, 50, -1, 60, -1, -1,30,70, -1,80,110, -1,120, -1, -1,90, -1, -1,40,100, -1, -1, -1 };
		root = construct(arr);
		display(root);
	}
}